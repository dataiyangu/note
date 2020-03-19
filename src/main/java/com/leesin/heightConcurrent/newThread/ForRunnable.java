package com.leesin.heightConcurrent.newThread;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/18 10:45
 * @version:
 * @modified By:
 */
public class ForRunnable implements java.lang.Runnable {
    @Override
    public void run() {
        System.out.println("Runnable");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ForRunnable());
        thread.start();
    }
}
