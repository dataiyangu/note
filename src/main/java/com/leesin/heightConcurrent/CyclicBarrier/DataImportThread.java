package com.leesin.heightConcurrent.CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/22 22:26
 * @version:
 * @modified By:
 */
//CyclicBarrier 的字面意思是可循环使用（Cyclic）的屏障
// （Barrier）。它要做的事情是，让一组线程到达一个屏障（也
// 可以叫同步点）时被阻塞，直到最后一个线程到达屏障时，
// 屏障才会开门，所有被屏障拦截的线程才会继续工作。
// CyclicBarrier 默认的构造方法是 CyclicBarrier(int parties)，
// 其参数表示屏障拦截的线程数量，每个线程调用 await 方
// 法告诉 CyclicBarrier 当前线程已经到达了屏障，然后当前线程被阻塞
// 使用场景
// 当存在需要所有的子任务都完成时，才执行主任务，这个
// 时候就可以选择使用 CyclicBarrier



public class DataImportThread extends Thread{
    private CyclicBarrier cyclicBarrier;

    private String path;

    public DataImportThread(CyclicBarrier cyclicBarrier, String path) {
        this.cyclicBarrier = cyclicBarrier;
        this.path = path;
    }

    @Override
    public void run() {
        System.out.println("开始导入："+path+"位置数据");
        try {
            //阻塞
            cyclicBarrier.await();  //相当于在这里condition.await()
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

    }
}
