package com.leesin.heightConcurrent.Interrupt;

import java.util.concurrent.TimeUnit;

/**
 * @description: interrupt
 * @author: Leesin.Dong
 * @date: Created in 2020/3/17 15:05
 * @version:
 * @modified By:
 */
public class InterruptDemo1 {
    private static int i;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
            // 默认情况下isInterrupted返回false，通过thread.interrupt变成了true
                i++;
            }
            System.out.println("Num:"+i);
        }, "interruptDemo");
        thread.start();
        TimeUnit.SECONDS.sleep(1);
        //加不加这句话，加上这句话就会中断了。
        // thread.interrupt();
    }
}
