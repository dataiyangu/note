package com.leesin.heightConcurrent.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/22 18:10
 * @version:
 * @modified By:
 */
//countdownlatch 是一个同步工具类，它允许一个或多个线
// 程一直等待，直到其他线程的操作执行完毕再执行。从命
// 名可以解读到 countdown 是倒数的意思，类似于我们倒计
// 时的概念。
// countdownlatch 提供了两个方法，一个是 countDown，
// 一个是 await， countdownlatch 初始化的时候需要传入一
// 个整数，在这个整数倒数到 0 之前，调用了 await 方法的
// 程序都必须要等待，然后通过 countDown 来倒数。


//    减到0才会执行await,而且会唤醒所有的await
public class CountDownLatchDemo {

    //从代码的实现来看，有点类似 join 的功能，但是比 join 更
    // 加灵活。 CountDownLatch 构造函数会接收一个 int 类型
    // 的参数作为计数器的初始值，当调用 CountDownLatch 的
    // countDown 方法时，这个计数器就会减一。
    // 通过 await 方法去阻塞去阻塞主流程
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(() -> {
            System.out.println("" + Thread.currentThread().getName() + "执行中");
            //主要就是countDown方法
            countDownLatch.countDown();
            System.out.println("" + Thread.currentThread().getName() + "执行完毕");
        }, "t1").start();

        new Thread(() -> {
            System.out.println("" + Thread.currentThread().getName() + "执行中");
            countDownLatch.countDown();
            System.out.println("" + Thread.currentThread().getName() + "执行完毕");
        }, "t2").start();

        new Thread(() -> {
            System.out.println("" + Thread.currentThread().getName() + "执行中");
            countDownLatch.countDown();
            System.out.println("" + Thread.currentThread().getName() + "执行完毕");
        }, "t3").start();

        countDownLatch.await();
        System.out.println("所有线程执行完毕");
    }
}
