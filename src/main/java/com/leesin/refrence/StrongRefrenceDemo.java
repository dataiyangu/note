package com.leesin.refrence;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/25 0025 21:35
 * @modified By:
 */
public class StrongRefrenceDemo {
    //静态变量，只有类被卸载，才会被销毁
    static Object strongRef = new Object();
    public static void main(String[] args) {
        Object object = strongRef;
        strongRef = null;
        System.gc();
        System.out.println("gc之后："+object);

        A a = new A();
        Apple apple = new Apple(a);
        a = null;
        System.gc();
        System.out.println(a);

    }

    static class Apple{
        public Apple(A a) {
        }
    }
    static class A{

    }
}
