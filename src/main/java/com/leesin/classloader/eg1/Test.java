package com.leesin.classloader.eg1;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/27 0027 11:27
 * @modified By:
 */
public class Test {
    static {
        System.out.println("Test类的静态块1");//1
    }

    static Sample sample = new Sample("静态成员变量sample初始化");//2
    Sample sample1 = new Sample("sample普通成员变量初始化");//6

    static{
        System.out.println("Test类静态块2");//3
    }

    public void a(Sample sample1) {
        System.out.println("父类构造方法");
    }

    Test() {
        System.out.println("Test类的无参数构造");//8
    }

    Sample sample2 = new Sample("sample2普通成员变量初始化");//7
}
