package com.leesin.heightConcurrent.join;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class JoinTester01 implements Runnable {

    private String name;

    public JoinTester01(String name) {
        this.name = name;
    }

    public void run() {
        System.out.printf("%s begins: %s\n", name, new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("%s has finished: %s\n", name, new Date());
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new JoinTester01("One"));
        Thread thread2 = new Thread(new JoinTester01("Two"));
        thread1.start();
        thread2.start();
        //join：等待这个线程结束；
        // 也就是说，t.join()方法阻塞调用此方法的线程(calling thread)进入 TIMED_WAITING 状态，直到线程t完成，此线程再继续；

        //例子中有join和没join有区别
        try {
            // 底层是调用wait方法，t.join()相当于t.wait()，当前线程调用的t.wait()，当前线程阻塞
            // 只要子线程t是活的就不停的等待，直到被t唤醒了当前线程。
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("Main thread is finished");
    }

}