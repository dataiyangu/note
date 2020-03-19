package com.leesin.heightConcurrent.waitNotify.producerConsumer;

public class Vendor {
    // 定义库存数量
    //多个线程共同操作这个vender这个一个对象中的count，是可以叠加的用synchronized保证同步
    //volidate是保证多个线程中的数字同步
    private int count;

    // 定义最大库存
    private final int MAX_COUNT = 10;

    public synchronized void production() {
        while (count >= MAX_COUNT) {
            try {
                System.out.println(Thread.currentThread().getName() + "库存数量达到最大值，停止生产。");
                // 此时生产线程全部进入等待状态
                //被consumer唤醒
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 否则生产商品
        count++;
        System.out.println(Thread.currentThread().getName() + "正在生产商品，当前库存为：" + count);
        //唤醒消费者的
        notifyAll();

    }

    public synchronized void consumers() {
        while (count <= 0) {
            try {
                System.out.println(Thread.currentThread().getName() + "没有商品了，消费者处于等待状态...");
                //被producer唤醒
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        System.out.println(Thread.currentThread().getName() + "正在消费，当前库存为：" + count);
        //唤醒生产者的
        notifyAll();
    }
}