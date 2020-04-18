package com.leesin.zookeeper;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * @description: zkclient api 使用
 * @author: Leesin Dong
 * @date: Created in 2020/4/18 20:19
 * @modified By:
 */
public class ZkClientDemo implements Watcher {

    static ZooKeeper zooKeeper;

    static {
        String CONNECTION_STR = "192.168.8.111:2181,192.168.8.112:2181,192.168.8.113:2181";
        try {
            //在创建一个 ZooKeeper 客户端对象实例时，我们通过 new Watcher()向构造方法中
            // 传入一个默认的 Watcher, 这个 Watcher 将作为整个 ZooKeeper 会话期间的默认
            // Watcher，会一直被保存在客户端 ZKWatchManager 的 defaultWatcher 中;代码如
            // 下
            zooKeeper = new ZooKeeper(CONNECTION_STR, 5000, new ZkClientDemo());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        System.out.println("eventType:"+watchedEvent.getType());
        //数据放生了变化的事件
        if (watchedEvent.getType()== Event.EventType.NodeDataChanged) {
            try {
                //重新监听
                // 实现循环监听
                //在客户端不断的执行set /watcher xxx 重复的监听到
                zooKeeper.exists(watchedEvent.getPath(), true);
            } catch (KeeperException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //getData()/  exists  /getChildren   添加监听还见
    public static void main(String[] args) throws KeeperException, InterruptedException, IOException {
        String path = "/watcher";
        if (zooKeeper.exists(path, true) == null) {
            zooKeeper.create(path, "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        Thread.sleep(1000);
        System.out.println("--------------");
        //添加监听事件
        //每个znode由3部分组成: stat. 此为状态信息, 描述该znode的版本, 权限等信息. data. 与该znode关联的数据. children.
        // 该znode下的子节点.  znode的stat包含介绍：
        // https://blog.csdn.net/heyutao007/article/details/43118097

        //可以看到如果存在，会返回节点的stat信息，不存在就是null
        Stat stat = zooKeeper.exists(path, true);//true标识是用zookeeper事例中配置的watcher，使用全局的watcher，
        // 即上面的process方法，如果不想用这个，可以在true这个参数的位置，new 一个watch
        System.out.println("stat--"+stat);
        System.in.read();
    }

}
