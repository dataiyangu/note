package com.leesin.heightConcurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureTest implements Callable {

    @Override
    public Object call() throws Exception {
        String a = "a";
        Thread.sleep(1000000);
        return a;
    }

    public static void main(String[] args) {
        FutureTest futureTest = new FutureTest();
        FutureTask futureTask = new FutureTask(futureTest);
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

