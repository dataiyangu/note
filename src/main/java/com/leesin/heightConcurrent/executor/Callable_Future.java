package com.leesin.heightConcurrent.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/26 21:26
 * @version: ${VERSION}
 * @modified By:
 */

//1. execute 只可以接收一个 Runnable 的参数
// 2. execute 如果出现异常会抛出
// 3. execute 没有返回值
// 1. submit 可以接收 Runable 和 Callable 这两种类型的参数，
// 2. 对于 submit 方法，如果传入一个 Callable，可以得到一个 Future 的返回值
// 3. submit 方法调用不会抛异常，除非调用 Future.get

public class Callable_Future implements Callable {

    @Override
    public Object call() throws Exception {
        //阻塞案例演示
        // Thread.sleep(3000);
        return "hello world";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable_Future callable_future = new Callable_Future();
        FutureTask futureTask = new FutureTask(callable_future);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}
