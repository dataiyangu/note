package com.leesin.heightConcurrent.volatile_;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/20 14:16
 * @version:
 * @modified By:
 */
public class VolatileDemo {
    public volatile static boolean stop = false;

    public static void main(String [] args) throws InterruptedException {
        new Thread(() -> {
            int i = 0;
            while (!stop) {
                i++;
            }
        }).start();
        System.out.println("begin start thread");
        Thread.sleep(1000);
        stop = true;
    }
}
