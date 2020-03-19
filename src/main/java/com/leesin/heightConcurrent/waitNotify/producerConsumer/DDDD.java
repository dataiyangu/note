package com.leesin.heightConcurrent.waitNotify.producerConsumer;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/18 10:03
 * @version:
 * @modified By:
 */
public class DDDD extends Thread{
    int i ;
    @Override
    public void run() {
        i++;
        System.out.println(i);
    }

    public static void main(String[] args) {
        //多线程操作同一个对象，里面的数字是叠加的，但是可能存在同步问题
        DDDD dddd = new DDDD();
        for (int i = 0; i < 1000; i++) {
            new  Thread(dddd).start();
        }

        // new Thread(new DDDD()).start();
        // new Thread(new DDDD()).start();
        // new Thread(new DDDD()).start();
        // new Thread(new DDDD()).start();
    }
}
