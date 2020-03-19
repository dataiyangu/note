package com.leesin.heightConcurrent.sixStatus;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class ThreadStatus {
    public static void main(String[] args) {
//TIME_WAITING
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "timewaiting").start();//TIME_WAITING

        //WAITING，线程在 ThreadStatus 类锁上通过 wait 进行等待
        new Thread(() -> {
            while (true) {
                synchronized (ThreadStatus.class) {
                    try {
                        //这里必须这么写，wait需要知道锁定的对象，类锁无法锁定wait所属对象
                        //简单记住就是wait()前面加上当前加锁的对象，也就是当前synchronized()里面的对象
                        //而且只有是同一把锁才能对线程进行操作。
                        // 如果是对象就用对象，如果是class就是xxx.class
                        //但是等待的是当前调用wait的线程，即main，而不是xxx.class
                        ThreadStatus.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Waiting").start();//WAITING

        //线程在 ThreadStatus 加锁后，不会释放锁
        new Thread(new BlockedDemo(), "BlockDemo- 01").start();//TIME_WAITING
        new Thread(new BlockedDemo(), "BlockDemo- 02").start();//BLOCKED
        new Thread(new BlockedDemoForWait(), "BlockDemo-wait").start();
        //waitting，经过测试
        // https://blog.csdn.net/jackie_xiaonan/article/details/47907625这篇文章是错误的，
        // 循环调用wait并不会变成block
    }

    static class BlockedDemo extends Thread {
        public void run() {
            synchronized (BlockedDemo.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class BlockedDemoForWait extends Thread {
        @SneakyThrows
        @Override
        public void run() {
            boolean flag = true;
            synchronized(this)
            {
                while (flag)
                {
                    this.wait();
                }
            }
        }
    }

}