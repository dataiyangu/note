// package com.leesin.heightConcurrent.threadLocal;
//
// /**
//  * @description:
//  * @author: Leesin.Dong
//  * @date: Created in 2020/3/25 17:40
//  * @version: ${VERSION}
//  * @modified By:
//  */
//
// //可能出面试题
// public class Demo2 {
//     static Demo demo = new Demo();//共享数据
//         static ThreadLocal<Demo> num = ThreadLocal.withInitial(() -> demo);
//         static ThreadLocal<String> strLocal = ThreadLocal.withInitial(() -> "Hello");
//
//         public static void main(String[] args) {
//             Thread[] threads = new Thread[5];
//
//             for (int i = 0; i < threads.length; i++) {
//                 threads[i] = new Thread(() -> {
//                     Demo demo1 = num.get();
//                     //这种方式还会起到隔离作用哦吗？
//                     //ThreadLocal是否会遇到跨线程的数据安全性问题
//
//                     //get方法中有一个setInitialValue->initialValue，如果返回的是同一个实例的话，多个线程
//                     //修改同一个实例还是改变的一个共享的数据，所以是无法保证原子性的
//                     demo1.incr();
//                 },"Thread-"+i);
//             }
//
//             for (Thread thread : threads) {
//                 thread.start();
//             }
//         }
// }
