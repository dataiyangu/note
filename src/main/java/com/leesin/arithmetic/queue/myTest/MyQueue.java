package com.leesin.arithmetic.queue.myTest;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/30 0030 20:31
 * @modified By:
 */
public class MyQueue {
    public int[] arrays;
    public int front;
    public int rear;

    public MyQueue(int[] arrays, int front, int rear) {
        this.arrays = arrays;
        this.front = front;
        this.rear = rear;
    }

    public static boolean isFull(MyQueue myQueue) {
        if ((myQueue.rear + 1) % myQueue.arrays.length == myQueue.front) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEmpty(MyQueue myQueue) {
        if (myQueue.rear == myQueue.front) {
            return true;
        } else {
            return false;
        }
    }

    public static void enQueue(MyQueue myQueue,int value) {
        if (!isFull(myQueue)) {
            myQueue.arrays[myQueue.rear] = value;
            myQueue.rear = (myQueue.rear + 1) % myQueue.arrays.length;
        }
    }

    public static void travers(MyQueue myQueue) {
        int i = myQueue.front;
        while (myQueue.rear != i ) {
            System.out.print(myQueue.arrays[i]+" ");
            i = (i + 1) % myQueue.arrays.length;
        }
        System.out.println();
    }

    public static void outQueue(MyQueue myQueue) {
        if (!isEmpty(myQueue)) {
            int value = myQueue.arrays[myQueue.front];
            System.out.println(value);
            myQueue.front = (myQueue.front - 1) % myQueue.arrays.length;
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(new int[6], 0, 0);
        System.out.println(isEmpty(myQueue));

        enQueue(myQueue,1);
        enQueue(myQueue,2);
        enQueue(myQueue,3);
        enQueue(myQueue,4);
        enQueue(myQueue,5);

        System.out.println(isFull(myQueue));

        travers(myQueue);

        outQueue(myQueue);
    }
}
