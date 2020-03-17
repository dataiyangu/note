package com.leesin.heightConcurrent.Interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @description: interrupt复位
 * @author: Leesin.Dong
 * @date: Created in 2020/3/17 15:07
 * @version:
 * @modified By:
 */
public class InterruptDemo2 {
    private static int i;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            while (true) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("before:"+Thread.currentThread().isInterrupted());
                    //对线程进行复位
                    Thread.interrupted();
                    System.out.println("after:" + Thread.currentThread().isInterrupted());
                }
            }
        },"interruptDemo");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
    }
}
