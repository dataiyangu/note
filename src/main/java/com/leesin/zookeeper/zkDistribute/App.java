package com.leesin.zookeeper.zkDistribute;

import org.I0Itec.zkclient.ZkClient;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/4/14 21:48
 * @modified By:
 */
public class App {
    private static String CONNECTION_STR = "192.168.8.111:2181,192.168.8.112:2181,192.168.8.113:2181";

    public static void main(String[] args)  {
        //建立连接
        ZkClient zkClient = new ZkClient(CONNECTION_STR, 50000);
        ZkClientDistribute zcd = new ZkClientDistribute("/leesin", zkClient);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                zcd.lock();
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                zcd.unlock();
            },"Thread-"+i).start();
        }
    }
}
