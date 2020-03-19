package com.leesin.heightConcurrent.waitNotify.producerConsumer;

public class GetTarget implements Runnable {

    private Vendor vendor;

    public GetTarget(Vendor vendor) {
        this.vendor = vendor;
    }

    @Override
    public void run() {
        while(true){
            vendor.consumers();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}