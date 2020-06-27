package com.leesin.classloader.eg2;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/27 0027 11:42
 * @modified By:
 */
public class SingtonDemo {
    //首先对静态成员变量初始化
    //在准备阶段
    // private static SingtonDemo instance = null
    //count1 = 0
    //count2 = 0
    private static SingtonDemo instance = new SingtonDemo();
    public static int count1;
    public static int count2 = 0;

    //在初始化阶段
    // 初始化了SingtonDemo，调用这里
    private SingtonDemo() {
        count1++; //1
        count2++; //1    接着初始化count2（按照代码顺序往下初始化的），又赋值为0了
    }

    public static SingtonDemo getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        SingtonDemo.getInstance();
        System.out.println("count1="+count1);
        System.out.println("count2="+count2);
    }

}
