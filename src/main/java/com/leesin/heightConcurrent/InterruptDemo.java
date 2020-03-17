package com.leesin.heightConcurrent;

import org.omg.PortableServer.THREAD_POLICY_ID;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/17 14:26
 * @version:
 * @modified By:
 */
public class InterruptDemo {
    private static int i;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            // while (!Thread.currentThread().isInterrupted()) {
            // // 默认情况下isInterrupted返回false，通过thread.interrupt变成了true
            //     i++;
            // }
            // System.out.println("Num:"+i);

            // while (true) {
            //     if (Thread.currentThread().isInterrupted()) {
            //         System.out.println("before:"+Thread.currentThread().isInterrupted());
            //         //对线程进行复位
            //         Thread.interrupted();
            //         System.out.println("after:" + Thread.currentThread().isInterrupted());
            //     }
            // }

            // while (!Thread.currentThread().isInterrupted()) {
            //     // i++;
            // }
            // System.out.println("num:" + i);

            while (!Thread.currentThread().isInterrupted()) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                //   还在走的时候接受到了中断标志。
                //    抛出异常之前调用isInterrupted将会返回false
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Num:"+i);
        },"interruptDemo");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        thread.interrupt();
        System.out.println(thread.isInterrupted());
    }
}