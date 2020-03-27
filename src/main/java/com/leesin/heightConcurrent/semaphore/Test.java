package com.leesin.heightConcurrent.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/22 22:13
 * @version:
 * @modified By:
 */
// 使用场景
//         Semaphore 比较常见的就是用来做限流操作了。
//
// semaphore 也就是我们常说的信号灯， semaphore 可以控
// 制同时访问的线程个数，通过 acquire 获取一个许可，如
// 果没有就等待，通过 release 释放一个许可。有点类似限流
// 的作用。叫信号灯的原因也和他的用处有关，比如某商场
// 就 5 个停车位，每个停车位只能停一辆车，如果这个时候
// 来了 10 辆车，必须要等前面有空的车位才能进入。

public class Test {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            new Car(i, semaphore).start();
        }
    }

    static class Car extends Thread {
        private int num;
        private Semaphore semaphore;
        public Car(int num, Semaphore
                semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();//获得一个许可
                System.out.println("第"+num+"占用一个停车位");
                TimeUnit.SECONDS.sleep(2);
                System.out.println("第"+num+"俩车走喽");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
