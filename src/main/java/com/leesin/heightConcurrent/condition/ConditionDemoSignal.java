package com.leesin.heightConcurrent.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/22 13:56
 * @version:
 * @modified By:
 */
public class ConditionDemoSignal implements Runnable {

    private Lock lock;
    private Condition condition;

    public ConditionDemoSignal(Lock lock, Condition condition) {
        this.lock = lock;
        this.condition = condition;
    }

    @Override
    public void run() {
        System.out.println("begin ConditionDemoSignal");
        try {
            lock.lock();
            condition.signal();
            // condition.signalAll();
            //为什么会走完这句话才唤醒await，而不是执行完condition.signal();就唤醒？
            // 因为这边signal只是放到了同步队列中，要等下面unlock唤醒
            //或者存在一种情况，就是放入到同步队列之前或者执行完ws>0判断之后这段时间前面的节点是取消状态
            //这种情况当时就会返回。
            System.out.println("end ConditionDemoSignal");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
}
