package com.leesin.heightConcurrent.newThread;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/18 10:45
 * @version:
 * @modified By:
 */
public class ForThread extends java.lang.Thread {
    @Override
    public void run() {
        System.out.println("Thread");
    }

    public static void main(String[] args) {
        ForThread thread = new ForThread();
        thread.start();
    }
}
