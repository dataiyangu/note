package com.leesin.zookeeper.zkDistribute;

import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @description:
 * @author: Administrator
 * @date: Created in 2020/4/14 21:49
 * @modified By:
 */
public class ZkClientDistribute implements Lock {
    //根节点，命名空间
    private String basePath;

    ZkClient zkClient;

    //第几个进来的？
    private static AtomicInteger count = new AtomicInteger(-1);

    Map<Thread, LockData> chm = new ConcurrentHashMap<>();

    public void lock() {
        //根据顺序命名
        int currentTime = count.incrementAndGet();
        //省去了可重入锁的逻辑
        String childPath = basePath + "/" + String.valueOf(currentTime);
        LockData lockData = new LockData(Thread.currentThread(), currentTime);
        chm.put(Thread.currentThread(), lockData);
        //创建节点
        String sucessPath = getsLockLoop(lockData, childPath);
        System.out.println(basePath+"/"+sucessPath + "获得锁成功了！");
    }

    private String getsLockLoop(LockData lockData, String childPath) {
        Boolean hasLock = false;
        createsTheLock(childPath);
        String successPath;
        while (!hasLock) {
            Result result = getsTheLock(lockData, 1, basePath);
            if (result.getsTheLock) {
                hasLock = true;
                // System.out.println(lockData.currentTime + "获得了锁");
                break;
            } else {
                //添加监听
                //监听节点
                Object lock = new Object();
                watcher(result.pathToWatch, lock);
                synchronized (lock) {
                    try {
                        //阻塞
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        successPath = String.valueOf(lockData.currentTime);
        return successPath;
    }

    private void watcher(String pathToWatch, Object o) {
        zkClient.subscribeDataChanges(pathToWatch, new IZkDataListener() {
            // 得到删除节点的path
            @Override
            public void handleDataDeleted(String path) throws Exception {
                System.out.println(">>>监听到删除的节点为:" + path);
                new Thread(() -> {
                    synchronized (o) {
                        o.notify();
                    }
                }).start();
            }

            // 得到变更的节点和变更的内容
            @Override
            public void handleDataChange(String path, Object data) throws Exception {
                // notifyAll();
                System.out.println(">>>监听到变更的节点为:" + path + ", 变更内容为:" + data);
            }
        });

    }

    //创建临时节点
    private void createsTheLock(String path) {
        //递归创建子节点（此时父节点并不存在）
        zkClient.createPersistent(path, true);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(path + "创建成功了");
        // System.out.println("目前子节点：" + zkClient.getChildren(basePath));
    }

    public ZkClientDistribute(String basePath, ZkClient zkClient) {
        this.basePath = basePath;
        this.zkClient = zkClient;
        zkClient.createPersistent(basePath, true);
    }

    public void lockInterruptibly() throws InterruptedException {

    }

    public boolean tryLock() {
        return false;
    }

    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    public void unlock() {
        LockData lockData = chm.get(Thread.currentThread());
        //递归删除
        System.out.println("准备删除" + basePath+"/"+lockData.currentTime);
        //删除第一个
        zkClient.delete(basePath + "/" + lockData.currentTime);
    }

    public Condition newCondition() {
        return null;
    }

    public Result getsTheLock(LockData lockData, int maxLeases, String path) {
        Boolean getsTheLock = getCurrentIndex(lockData) < maxLeases;
        //获得全部子节点
        //pathToWatch 是前一个节点
        String pathToWatch = "";
        pathToWatch = getsTheLock ? null : basePath + "/" + (getCurrentIndex(lockData) - 1);
        // System.out.println("getCurrentIndex(lockData) "+getCurrentIndex(lockData)+" pathToWatch "+pathToWatch);
        return new Result(getsTheLock, pathToWatch);
    }

    private Integer getCurrentIndex(LockData lockData) {
        List<String> children = zkClient.getChildren(basePath);
        if (children.contains(String.valueOf(lockData.currentTime))) {
            int index = children.indexOf(String.valueOf(lockData.currentTime));
            return index;
        }
        return 100;
    }

    private static class LockData {
        final Thread owningThread;
        final int currentTime;

        private LockData(Thread owningThread, int currentTime) {
            this.owningThread = owningThread;
            this.currentTime = currentTime;
        }
    }

    private class Result {
        final Boolean getsTheLock;
        final String pathToWatch;

        private Result(Boolean getsTheLock, String pathToWatch) {
            this.getsTheLock = getsTheLock;
            this.pathToWatch = pathToWatch;
        }
    }
}
