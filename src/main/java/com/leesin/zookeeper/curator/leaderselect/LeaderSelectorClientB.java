package com.leesin.zookeeper.curator.leaderselect;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;
import org.apache.curator.retry.ExponentialBackoffRetry;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/4/13 22:20
 * @version: ${VERSION}
 * @modified By:
 */
//Closeable Java7中的实现自动关闭的操作，下面的close方法出自这里
public class LeaderSelectorClientB extends LeaderSelectorListenerAdapter implements Closeable {
    //如果在构造方法中leaderSelector.autoRequeue()则会变成leader Election模式，继续参与竞争，自动重复参与选举
    private  String name;//标识当前进程
    private LeaderSelector leaderSelector;//Leader选举的API
    private CountDownLatch countDownLatch = new CountDownLatch(1);

    public LeaderSelectorClientB(String name) {
        this.name = name;
        //如果在构造方法中leaderSelector.autoRequeue()则会变成leader Election模式，继续参与竞争，自动重复参与选举
    }

    public LeaderSelector getLeaderSelector() {
        return leaderSelector;
    }

    public void setLeaderSelector(LeaderSelector leaderSelector) {
        leaderSelector = leaderSelector;
    }


    public void start() {
        //看源码的话从start方法进入
        leaderSelector.start();//开始竞争leader
    }

    @Override
    public void close() throws IOException {
        leaderSelector.close();
    }

    @Override
    public void takeLeadership(CuratorFramework curatorFramework) throws Exception {
        //如果进入当前的方法，意味着当前的进程获得了锁。获得锁以后，这个方法会被回调
        //这个方法执行结束之后，表示释放leader权限
        System.out.println(name + "->现在是leader了");
        countDownLatch.await(); //阻塞当前的进程防止leader丢失，为了例子演示，否则，当前这个刚刚获得leader，又丢失了leader
    }

    private static String CONNECTION_STR = "192.168.8.111:2181,192.168.8.112:2181,192.168.8.113:2181";

    public static void main(String[] args) throws IOException {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder().
                connectString(CONNECTION_STR).sessionTimeoutMs(5000).
                retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();
        curatorFramework.start();
        //ClientA名字
        LeaderSelectorClientB leaderSelectorClient= new LeaderSelectorClientB("ClientB");
        //leader加一个节点专门用来leader选举，类似internalProcess中创建的最上面的节点
        LeaderSelector leaderSelector = new LeaderSelector(curatorFramework, "/leader", leaderSelectorClient);
        leaderSelectorClient.setLeaderSelector(leaderSelector);
        leaderSelector.start();//开始选举
        System.in.read();//为了让进程不关掉。关掉就不发看到效果了
    }
}
