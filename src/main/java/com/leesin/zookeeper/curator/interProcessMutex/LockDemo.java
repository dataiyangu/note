package com.leesin.zookeeper.curator.interProcessMutex;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.apache.curator.retry.ExponentialBackoffRetry;

/**
 * @description: 分布式锁
 * @author: Leesin.Dong
 * @date: Created in 2020/4/13 10:46
 * @version: ${VERSION}
 * @modified By:
 */
public class LockDemo {
    private static String CONNECTION_STR = "192.168.8.111:2181,192.168.8.112:2181,192.168.8.113:2181";

    public static void main(String[] args) {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().
                connectString(CONNECTION_STR).sessionTimeoutMs(5000).
                retryPolicy(new ExponentialBackoffRetry(1000, 3)).
                build();

        curatorFramework.start();

        //locks锁节点
        final InterProcessMutex interProcessMutex = new InterProcessMutex(curatorFramework, "/locks");

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "尝试竞争锁");
                try {
                    interProcessMutex.acquire();//阻塞竞争锁
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "成功获得锁");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    interProcessMutex.release();//释放锁
                } catch (Exception e) {
                    e.printStackTrace();
                }

            },"Thread---"+i).start();
        }

    }

}
