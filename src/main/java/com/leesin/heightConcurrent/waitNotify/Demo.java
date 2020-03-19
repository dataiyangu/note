package com.leesin.heightConcurrent.waitNotify;

import java.util.concurrent.TimeUnit;
//wait()和notify()都是定义在Object类中，为什么如此设计。
//因为synchronized中的这把锁可以是任意对象，所以任意对象都可以调用wait()和notify()，
// 并且只有同一把锁才能对线程进行操作，不同锁之间是不可以相互操作的，所以wait和notify属于Object。请看如下API文档说明。

//一共开启了4个线程，当全部进入等待状态时，调用notify()方法唤醒线程，但很明显只唤醒了其中一条线程。
// 右上角显示程序并没有停止，原因就是其他3条线程仍在处于等待状态。
public class Demo {
    //wait
    public Thread newThread1(int i){
         return new Thread(() -> {
            synchronized (this ){
                System.out.println(Thread.currentThread().getName() + " 执行了...");
                try {
                    //相当于  this.wait();
                    //this.wait();
                    this.wait();
                    System.out.println("叫醒之后");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 执行完毕...");
            }
        },"wait线程--"+i);
    }
    //notify
    public Thread  newThread2(int i){
        return new Thread(() -> {
            synchronized (this ){
                // notify方法会随机叫醒一个处于wait状态的线程
                // 相当于this.notify();
                // this.notify();
                // notify();
                // notifyAll叫醒所有的处于wait线程，争夺到时间片的线程只有一个
                notifyAll();
                System.out.println("叫醒线程叫醒之后休眠开始...");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"notify线程--"+i);
    }
    public static void main(String[] args) {
        Demo demo = new Demo();
        // 开启线程，
        demo.newThread1(1).start();
        demo.newThread1(2).start();
        demo.newThread1(3).start();
        demo.newThread1(4).start();
        demo.newThread1(5).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        demo.newThread2(1).start();
    }
}