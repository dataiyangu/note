package com.leesin.heightConcurrent.practic;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/22 22:57
 * @version:
 * @modified By:
 */

//使用 ReentrantLock 和 Condition 实现一个阻塞队列

// https://blog.csdn.net/jisuanji12306/article/details/82392250
public class ReentantLockAndConditionQueue<T> {
    private List<T> list = new ArrayList();
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition condition = reentrantLock.newCondition();
    private AtomicInteger count = new AtomicInteger(0);
    private int MIN_SIZE = 0;
    private int MAX_SIZE;

    public ReentantLockAndConditionQueue(int MAX_SIZE) {
        this.MAX_SIZE = MAX_SIZE;
    }

    public void put(T object) {
        try {
            reentrantLock.lock();
            if (count.get() == MAX_SIZE) {
                condition.await();
                System.out.println("put方法被唤醒了");
            }
            list.add(object);
            count.incrementAndGet();
            System.out.println("添加了一个元素：" + object);
            condition.signal();
        } catch (InterruptedException e) {
        } finally {
            reentrantLock.unlock();
        }
    }

    public void take() {
        try {
            reentrantLock.lock();
            if (count.get() == MIN_SIZE) {
                condition.await();
                System.out.println("take方法被唤醒了");
            }
            T t = list.get(0);
            list.remove(t );
            count.decrementAndGet();
            System.out.println("删除了一个元素：" + t );
            condition.signal();
        } catch (InterruptedException e) {
        } finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentantLockAndConditionQueue<Object> queue = new ReentantLockAndConditionQueue<>(5);
        new Thread(()->{
            while (true) {
                queue.take();
            }
        }).start();

        TimeUnit.SECONDS.sleep(1);

        queue.put(1);
        TimeUnit.SECONDS.sleep(1);
        queue.put(2);
        queue.put(3);
        queue.put(4);
        queue.put(5);
    }
}
