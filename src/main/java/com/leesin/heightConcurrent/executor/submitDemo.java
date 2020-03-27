package com.leesin.heightConcurrent.executor;

import java.util.concurrent.*;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/26 22:06
 * @version: ${VERSION}
 * @modified By:
 */
public class submitDemo implements Callable {
    @Override
    public Object call() throws Exception {
        //阻塞案例演示
        Thread.sleep(3000);
        return "hello world";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        submitDemo submitDemo = new submitDemo();
        Future future = executorService.submit(submitDemo);
        System.out.println(future.get());
    }
}