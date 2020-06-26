package com.leesin.refrence;

import java.lang.ref.SoftReference;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/25 0025 21:48
 * @modified By:
 */
public class SoftRefrenceDemo {
    public static void main(String[] args) {
        Object softRef = new Object();
        SoftReference softReference = new SoftReference(softRef);
        softRef = null;//被软引用的 设置成空，不会被回收，只有内存不足的情况下才会被回收
        softReference = null;//引用设置为空 立即被回收
        //使用软引用，获取软引用里对象
        System.out.println(softReference.get());
        //1 只有程序在发生oom异常前才会被自动回收，内存充足的情况下对象不会被回收
        //堆 2G内存，gc之后剩余1G ，如果过去的1024（1G）*1000秒之内 没有访问软引用，gc执行的时候会回收
        //在1024（1G）*1000秒之前，即使执行gc，也不会被回收

        //2 直接软引用指向null，不引用，也会被回收
    }
}
