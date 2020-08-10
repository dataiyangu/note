package interview;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/8/9 0009 9:29
 * @modified By:
 */
public class Jstack implements Runnable{
    @Override
    public void run() {
        while (true) {
            System.out.println("aaa");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Jstack jstack = new Jstack();
        new Thread(jstack).start();
    }
}
