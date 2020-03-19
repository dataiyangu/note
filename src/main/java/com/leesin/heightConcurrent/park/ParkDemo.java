package com.leesin.heightConcurrent.park;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/17 19:08
 * @version:
 * @modified By:
 */
public class ParkDemo {
    public static void main(String[] args) {

        Thread thread1 = new Thread(() -> {
            System.out.println("开始");
            LockSupport.park();
            System.out.println("第一次park");
            // LockSupport.unpark(Thread.currentThread());
            LockSupport.park();
            System.out.println("第二次park");
        }, "Thread1");

        Thread thread2 = new Thread(() -> {
            try {

            TimeUnit.SECONDS.sleep(1);
            LockSupport.unpark(thread1);
            // TimeUnit.SECONDS.sleep(1);
            // LockSupport.unpark(thread1);
                System.out.println("哈哈");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "Thread2");

        Thread thread3 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            LockSupport.unpark(thread1);
        }, "Thread3");

        thread1.start();
        thread2.start();
        // thread3.start();
    }
}
