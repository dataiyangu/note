package com.leesin.heightConcurrent.newThread;

import java.util.concurrent.*;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/18 11:27
 * @version:
 * @modified By:
 */
public class ForCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        int a = 1;
        int b = 2;
        System.out.println(a+b);
        return "执行结果" + (a + b);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        ForCallable callable = new ForCallable();
        //future是一个能获取返回值的接口
        Future<String> future = executorService.submit(callable);
        //future.get获得返回值
        System.out.println(future.get());
        executorService.shutdown();
    }

}
