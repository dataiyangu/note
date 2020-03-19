package com.leesin.heightConcurrent.join;

/**
 * @description:从代码中，我们可以发现。当millis==0时，会进入while(isAlive())循环；
 * 即只要子线程是活的，主线程就不停的等待。
 * 我们根据上面解释join()作用时的代码来理解join()的用法！
 * wait()的作用是让“当前线程”等待，而这里的“当前线程”是指当前运行的线程。
 * 虽然是调用子线程的wait()方法，但是它是通过“主线程”去调用的；所以，休眠的是主线程，而不是“子线程”！ 
 * 这样理解: 例子中的Thread t只是一个对象 , isAlive()判断当前对象(例子中的t对象)是否存活,
 * wait()阻塞的是当前执行的线程(例子中的main方法)
 * 可以看出，Join方法实现是通过wait()。 当main线程调用t.join时候，main线程会获得线程对象t的锁（wait 意味着拿到该对象的锁),
 * 调用该对象的wait()，直到该对象唤醒main线程 ，比如退出后。这就意味着main 线程调用t.join时，必须能够拿到线程t对象的锁。
 * 原文链接：https://blog.csdn.net/q5706503/article/details/84592449
 * @author: Leesin.Dong
 * @date: Created in 2020/3/18 8:28
 * @version:
 * @modified By:
 */
public class JoinSourceCode {
    /**
     *  Waits at most <code>millis</code> milliseconds for this thread to
     * die. A timeout of <code>0</code> means to wait forever.
     */
    //此处A timeout of 0 means to wait forever 字面意思是永远等待，其实是等到t结束后。
    public final synchronized void join(long millis)    throws InterruptedException {
        long base = System.currentTimeMillis();
        long now = 0;

        if (millis < 0) {
            throw new IllegalArgumentException("timeout value is negative");
        }

        if (millis == 0) {
            while (isAlive()) {
                //关键是这里
                //t.join()相当于t.wait()，当前线程调用的t.wait()，当前线程阻塞
                //只要子线程t是活的就不停的等待，直到被t唤醒了当前线程。
                wait(0);
            }
        } else {
            while (isAlive()) {
                long delay = millis - now;
                if (delay <= 0) {
                    break;
                }
                wait(delay);
                now = System.currentTimeMillis() - base;
            }
        }
    }

    //这里只是为了不报错，上面的isAlive调用的是jdk中的方法。
    public boolean isAlive() {
        return false;
    }
}
