package com.leesin.heightConcurrent.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/22 13:58
 * @version:
 * @modified By:
 */
public class Test {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition  condition = lock.newCondition();
        lock.newCondition();
        lock.newCondition();
        lock.newCondition();
        new Thread(new ConditionDemoWait(lock,condition)).start();
        new Thread( new ConditionDemoSignal(lock,condition)).start();
    }
}
