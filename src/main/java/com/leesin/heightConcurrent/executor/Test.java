package com.leesin.heightConcurrent.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/25 23:08
 * @version: ${VERSION}
 * @modified By:
 */
public class Test implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName());
    }

    static ExecutorService service = Executors.newFixedThreadPool(3);
    static ThreadPoolExecutor tpe = (ThreadPoolExecutor) service;

    public static void main(String[] args) {
        //如果希望线程池创建之后立即创建线程需要这么做
        tpe.prestartCoreThread();

        //允许设置大小
        tpe.setCorePoolSize(1);
        tpe.setMaximumPoolSize(2);

        for (int i = 0; i < 100; i++) {
            Test.service.submit(new Test());
        }
        Test.service.shutdown();
    }
}
