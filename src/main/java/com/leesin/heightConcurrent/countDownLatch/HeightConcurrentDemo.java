package com.leesin.heightConcurrent.countDownLatch;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/22 18:15
 * @version:
 * @modified By:
 */

//模拟高并发场景

// 总的来说，凡事涉及到需要指定某个人物在执行之前，要
// 等到前置人物执行完毕之后才执行的场景，都可以使用
// CountDownLatch
public class HeightConcurrentDemo implements Runnable{
    static CountDownLatch countDownLatch = new CountDownLatch(1);

    @SneakyThrows
    @Override
    public void run() {
        countDownLatch.await(); //阻塞1000个线程
        // TODO: 2020/3/22

        System.out.println("Thread"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(new HeightConcurrentDemo()).start();
        }
        countDownLatch.countDown();
    }
}
