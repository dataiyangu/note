package com.leesin.integer;

import java.lang.reflect.Field;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/26 0026 7:28
 * @modified By:
 */
public class Swap {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer a = 1, b = 2;
        System.out.println("before:a="+a+",b="+b);
        swap(a, b);
        System.out.println("after:a="+a+",b="+b);

        //验证缓存
        // Integer i1 = 1;
        // Integer i1 = 1;
        Integer i1 = 129;
        Integer i2 = 129;
        //Java里面直接用== 是不可取的， 因为比较的是两个值的内存地址的值
        //所以对于两个对象来说， 内存地址值是不想等的，所以这里应该是false
        //但是Interger里面有缓存的概念，所以运行的时候是true
        System.out.println(i1 == i2);
    }
    //写一个方法交换a和b的值
    private static void swap(Integer i1, Integer i2) throws NoSuchFieldException, IllegalAccessException {
        //这种方式不行
        // Integer tmp = i1;
        // i1 = i2;
        // i2 = tmp;

        Field field = Integer.class.getDeclaredField("value");
        //绕过安全你检查
        //面试：反射如果获得私有的final的成员变量做变更？setAccessible实现
        field.setAccessible(true);
        int temp = i1.intValue();
        //解决拆箱装箱，
        // Integer temp = new Integer(i1.intValue());
        // field.set(i1,i2.intValue());//i1 = Integer.valueof(i2.intValue).intValue()
        //解决拆箱装箱，setInt避免装箱操作
        field.setInt(i1,i2.intValue());//i1 = Integer.valueof(i2.intValue).intValue()
        // field.set(i2,temp);//Integer.valueOf(tmp).intValue()  temp装箱Integer.valueOf(tmp) = 2 所以i2 = 2
        //解决拆箱装箱，
        field.setInt(i2,temp);//Integer.valueOf(tmp).intValue()  temp装箱Integer.valueOf(tmp) = 2 所以i2 = 2
        System.out.println("tmp_"+Integer.valueOf(temp));//temp = 2  因为temp本来是基本类型int，但是变成了装箱
        //所以从缓存拿 cache[2]
    }
}
