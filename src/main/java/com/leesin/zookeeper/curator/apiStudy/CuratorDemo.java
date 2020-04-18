package com.leesin.zookeeper.curator.apiStudy;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/4/12 12:22
 * @version: ${VERSION}
 * @modified By:
 */
public class CuratorDemo {
    private static String CONNECTION_STR = "192.168.8.111:2181,192.168.8.112:2181,192.168.8.113:2181";

    public static void main(String [] args) throws Exception {
        //sessionTimeoutMs会话超时时间，超时则充实策略
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().
                connectString(CONNECTION_STR).sessionTimeoutMs(5000).
                retryPolicy(new ExponentialBackoffRetry(1000, 3)).
                namespace("curator").build();
        //重试策略： Curator 内部实现的几种重试策略:
        // • ExponentialBackoffRetry:重试指定的次数, 且每一次重试之
        // 间停顿的时间逐渐增加.
        // • RetryNTimes:指定最大重试次数的重试策略
        // • RetryOneTime:仅重试一次
        // • RetryUntilElapsed:一直重试直到达到规定的时间

        curatorFramework.start();
        //curd
        createData(curatorFramework);
        updateDate(curatorFramework);
        updateDate(curatorFramework);
        updateDate(curatorFramework);
        // deleteData(curatorFramework);


    }

    public static void createData(CuratorFramework curatorFramework) throws Exception {
        curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).
                forPath("/data/program", "test".getBytes());
    }

    public static void updateDate(CuratorFramework curatorFramework) throws Exception {
        curatorFramework.setData().forPath("/data/program", "up".getBytes());
    }

    public static void deleteData(CuratorFramework curatorFramework) throws Exception {
        Stat stat = new Stat();
        String s = new String(curatorFramework.getData().storingStatIn(stat).forPath("/data/program"));
        //这个version对应 stat xxx 中的 dataVersion
        //没进行一次crud就会+1，
        curatorFramework.delete().withVersion(stat.getVersion()).forPath("/data/program");
        // curatorFramework.delete().withVersion(0).forPath("/data/program");
    }
}
