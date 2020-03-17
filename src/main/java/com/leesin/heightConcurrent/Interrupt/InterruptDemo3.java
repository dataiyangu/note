package com.leesin.heightConcurrent.Interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @description: interrupt复位 抛出异常方式
 * @author: Leesin.Dong
 * @date: Created in 2020/3/17 15:09
 * @version:
 * @modified By:
 */
public class InterruptDemo3 {
    private static int i;
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
            // while (!Thread.currentThread().isInterrupted()) {
            //     // i++;
            // }
            // System.out.println("num:" + i);

            // 注释这里最后输出true，注释上面最后输出false
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    //sleep在jvm中源码实现？
                    //先判断时间是够小于0，小于抛出异常 timeout is negat。。。。
                    //判断并清除中断标志（is_interrupted方法，只能从true变成false），如果中断，就抛出异常。
                    TimeUnit.SECONDS.sleep(10);
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
