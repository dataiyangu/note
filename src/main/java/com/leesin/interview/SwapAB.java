package com.leesin.interview;

import java.lang.reflect.Field;

/**
 * @description: 写一个方法交换A和B的值
 * @author: Leesin Dong
 * @date: Created in 2020/8/2 0002 8:14
 * @modified By:
 */
public class SwapAB {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Integer A = 1;
        Integer B = 2;
        // swap(A,B);
        swap2(A,B);
        System.out.println(A+","+B);
    }

    public static void swap(Integer a, Integer b) throws NoSuchFieldException, IllegalAccessException {
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        Integer swap = new Integer(a.intValue());
        field.set(a,b.intValue());
        field.set(b,swap);
    }
    public static void swap2(Integer a,Integer b ) throws NoSuchFieldException, IllegalAccessException {
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        int swap = a.intValue();
        field.setInt(a, b.intValue());
        field.setInt(b, swap);
    }
}
