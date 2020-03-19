package com.leesin.heightConcurrent.join;

/**
 * @description: join会释放锁
 * @author: Leesin.Dong
 * @date: Created in 2020/3/18 22:50
 * @version:
 * @modified By:
 */
public class JoinReleaseLock  {

    public static void main(String[] args)  {
        ThreadB b = new ThreadB();
        ThreadA a = new ThreadA(b);
        a.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ThreadC c = new ThreadC(b);
        c.start();
    }


    static class ThreadA extends Thread {
        private ThreadB b;

        public ThreadA(ThreadB b) {
            super();
            this.b = b;
        }

        @Override
        public void run() {
            try {
                synchronized (b) {
                    b.start();
                    b.join();//执行join()方法的一瞬间，b锁立即释放。
                    for (int i = 0; i < Integer.MAX_VALUE; i++) {
                        String newString = new String();
                        Math.random();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadB extends Thread {

        @Override
        public void run() {
            try {
                System.out.println("b run begin timer=" + System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println("b run begin timer=" + System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        synchronized public void bService() {
            System.out.println("打印了BService time = " + System.currentTimeMillis());
        }
    }

    static class ThreadC extends Thread {

        private ThreadB threadB;

        public ThreadC(ThreadB threadB) {
            super();
            this.threadB = threadB;
        }

        @Override
        public void run() {
            threadB.bService();
        }
    }


}
