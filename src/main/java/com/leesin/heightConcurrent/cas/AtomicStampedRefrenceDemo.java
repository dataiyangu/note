package com.leesin.heightConcurrent.cas;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/20 10:01
 * @version:
 * @modified By:
 */
public class AtomicStampedRefrenceDemo {
    public static void main(String[] args) {
        String str1 = "aaa";
        String str2 = "bbb";
        //很多地方说这里stamp是时间戳，其实这里是通过代码传进来的值，愿意是多少就是多少
        AtomicStampedReference<String> reference = new AtomicStampedReference<String>(str1,1);
        reference.compareAndSet(str1,str2,reference.getStamp(),reference.getStamp()+1);
        System.out.println("reference.getReference() = " + reference.getReference());

        boolean b = reference.attemptStamp(str2, reference.getStamp() + 1);
        System.out.println("b: "+b);
        System.out.println("reference.getStamp() = "+reference.getStamp());

        boolean c = reference.weakCompareAndSet(str2,"ccc",4, reference.getStamp()+1);
        System.out.println("reference.getReference() = "+reference.getReference());
        System.out.println("c = " + c);
    }
}
