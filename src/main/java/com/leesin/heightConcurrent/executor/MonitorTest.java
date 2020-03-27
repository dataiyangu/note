package com.leesin.heightConcurrent.executor;

import java.util.concurrent.ExecutorService;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/26 21:06
 * @version: ${VERSION}
 * @modified By:
 */
public class MonitorTest implements Runnable {

    private static ExecutorService es = Monitor.newCachedThreadPool();

    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            es.execute(new MonitorTest());
        }
        es.shutdown();
    }
}
