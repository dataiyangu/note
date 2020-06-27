package com.leesin.classloader.eg1;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/27 0027 11:31
 * @modified By:
 */
public class TestSub extends Test{
    static Sample subSample = new Sample("TestSub类的subSample静态成员变量初始化");//4
    TestSub() {
        System.out.println("子类TestSub默认构造方法被调用");
    }

    Sample sumSam = new Sample("TestSub类的subSam1普通成员便令变量初始化");

    static {//5
        System.out.println("TestSub静态块开始执行");
    }

    public static void main(String[] args) {
        Test test = new Test();
    }
}

//这些类里面会输出哪些内容，输出顺序是怎样的？
//Classloader的变体

//类加载的时候包括
//验证、准备、解析、  初始化
//首先对 父类的 静态块或者静态成员 按照代码定义顺序 先执行----子类的 静态块或者静态成员
//普通成员变量的构造