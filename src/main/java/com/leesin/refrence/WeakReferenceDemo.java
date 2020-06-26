package com.leesin.refrence;

import java.lang.ref.WeakReference;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/25 0025 22:13
 * @modified By:
 */
public class WeakReferenceDemo {

    public static void main(String[] args) {
        //弱引用，软引用没有太大的区别，唯一的区别，不会像软引用一样，在一定时间之内没有被访问才会被回收
        //而是只要gc执行之后就会被回收
        Object weakObject = new Object();
        WeakReference weakReference = new WeakReference(weakObject);
        weakObject = null;//立即被回收
        System.gc();//gc注释掉，不会被回收
        System.out.println("after:"+weakReference.get());

        String str = "mic123";
        WeakReference weakReference1 = new WeakReference(str);
        weakObject = null;//不会被回收，因为String是被存在常量池里面，而gc是不会清理常量池的，所以对象不为空，所以弱引用回收策略跟对象的生命周期有关
        System.gc();//gc注释掉，不会被回收
        System.out.println("after:"+weakReference1.get());
    }
}
