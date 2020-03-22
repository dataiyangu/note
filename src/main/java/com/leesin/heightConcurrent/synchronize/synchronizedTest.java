package com.leesin.heightConcurrent.synchronize;

/**
 * @description:
 * 1. 修饰实例方法，作用于当前实例加锁，进入同步代码前
 * 要获得当前实例的锁
 * 2. 静态方法，作用于当前类对象加锁，进入同步代码前要
 * 获得当前类对象的锁
 * 3. 修饰代码块，指定加锁对象，对给定对象加锁，进入同
 * 步代码库前要获得给定对象的锁。
 * 不同的修饰类型，代表锁的控制粒度
 * @author: Leesin.Dong
 * @date: Created in 2020/3/19 8:53
 * @version:
 * @modified By:
 */
public class synchronizedTest {
    Object lock = new Object();
    //2种表现形式
    //2种作用范围（对象锁、类锁）却别是否夸对象跨线程被保护

    public synchronized void demo1() {

    }

    public void demo2() {
        // TODO: 2020/3/19
        synchronized (lock) {
            //保护才在线程安全的变量
        }
        // TODO: 2020/3/19
    }

    public synchronized static void demo3() {

    }

    public void demo4() {
        synchronized (synchronizedTest.class) {
            //保护才在线程安全的变量
        }
    }

    public static void main(String[] args) {
        synchronizedTest synchronizedTest=new synchronizedTest();
        synchronizedTest synchronizedTest2=new synchronizedTest();
        new Thread(()->synchronizedTest.demo1()).start();
        new Thread(()->synchronizedTest.demo1()).start();

        //锁的粒度不同？
        // 访问demo1不存在并发问题，因为两个对象，两把锁，不会去争抢锁
        // 访问demo3、demo4会存在并发问题，因为是static的、class级别的，是一把锁，会去争抢锁
    }
}
