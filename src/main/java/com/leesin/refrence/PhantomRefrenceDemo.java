package com.leesin.refrence;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/25 0025 22:49
 * @modified By:
 */
public class PhantomRefrenceDemo {
    public static void main(String[] args) throws InterruptedException {
        ReferenceQueue referenceQueue = new ReferenceQueue();
        Object phantomObject = new Object();
        PhantomReference phantomReference = new PhantomReference(phantomObject,referenceQueue);
        //get拿的值永远是空的值， null
        //和弱引用非常相似
        //什么时候get能拿到值？
        //当垃圾回收准备回收一个对象的时候，如果发现还有虚引用，就会把虚引用的对象加入到和这个虚引用关联的referenceQueue中
        //程序可以判断queue中是不是，加入了虚引用，去了解被引用对象是不是将要被垃圾回收
        System.out.println(phantomReference.get());//null

        phantomObject = null;
        System.gc();//phantomObject会被回收，回收之前
        System.out.println(phantomReference.get());//还是null
        Thread.sleep(200);
        System.out.println(referenceQueue.poll());//得到对象了java.lang.ref.PhantomReference@4617c264
        System.out.println(referenceQueue.poll());
        //GC触发之后，gc发现了虚引用，gc会将 phantomReference 插入到referenceQueue中，这个时候，对象并没有被GC回收
        //而是调用referenceQueue.poll()，返回phantomReference之后，被回收
        // (我猜少了句话，如果没有poll)，gc第二次发现虚引用之后，把之前的对象， 再次插入
        //这个队列，发现失败，因为这里面已经存在了，所以这个时候gc才会对这个对象进行回收

        //能够做什么？
        //1 可以通过RefrenceQueue，跟踪对象什么时候被释放
        //2 或者如果对象被释放之后，可以做一些后续的操作，比如queue.poll可以知道对象将要被回收，回收之前
        //希望做一些处理的话，就可以用到虚引用。

        //可以开一个线程从queue.poll 如果有数据，说明即将回收了，回收之前做点自己的事情。
    }
}
