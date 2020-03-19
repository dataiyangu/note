package com.leesin.heightConcurrent.waitNotify.producerConsumer;

public class Demo {
    public static void main(String[] args) {
        Vendor vendor = new Vendor();
        SetTarget set = new SetTarget(vendor);
        GetTarget get = new GetTarget(vendor);
        
        // 开启线程生产商品
        new Thread(set).start();
        new Thread(set).start();
        new Thread(set).start();
        new Thread(set).start();
        
        // 开启消费者线程
        new Thread(get).start();
    }
}