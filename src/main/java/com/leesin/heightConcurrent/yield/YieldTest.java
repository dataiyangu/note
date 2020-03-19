package com.leesin.heightConcurrent.yield;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/19 6:46
 * @version:
 * @modified By:
 */
public class YieldTest extends Thread{

    public YieldTest(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(""+this.getName()+"---"+i);
            if (i==30) {
                // this.yield();
                //就用Thead.yield(),他是静态方法，虽然this.yiel()语法上没有错误
                Thread.yield();
            }
        }
    }

    public static void main(String[] args) {
        YieldTest yieldTest1 = new YieldTest("大咪咪");
        YieldTest yieldTest2= new YieldTest("小咪咪");

        // yieldTest1.setPriority(Thread.MIN_PRIORITY);
        // yieldTest2.setPriority(Thread.MAX_PRIORITY);

        yieldTest1.start();
        yieldTest2.start();
    }
}
