package com.leesin.heightConcurrent.waitNotify.producerConsumer;

public class SetTarget implements Runnable {

    private Vendor vendor;

    public SetTarget(Vendor vendor) {
        this.vendor = vendor;
    }

    @Override
    public void run() {
        while(true){
            vendor.production();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}