package com.leesin.basic;

import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/24 18:03
 * @version:
 * @modified By:
 */
public class IteratorDemo {
    public static void main(String[] args) {
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(5);
        arrayBlockingQueue.add("1");

        Iterator iterator = arrayBlockingQueue.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

    }
}
