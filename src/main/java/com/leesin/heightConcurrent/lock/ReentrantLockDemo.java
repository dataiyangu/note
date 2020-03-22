package com.leesin.heightConcurrent.lock;

import java.util.concurrent.locks.Lock;

//怎么就可重入了？
// 这里面持有哪个锁？
public class ReentrantLockDemo {
    private static int count = 0;
    static Lock lock = new java.util.concurrent.locks.ReentrantLock();

    public static void inc() throws InterruptedException {
        lock.lock();
        Thread.sleep(1);
        count++;
        lock.unlock();
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                try {
                    ReentrantLockDemo.inc();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        Thread.sleep(3000);
        System.out.println("result:"+count);
    }
}