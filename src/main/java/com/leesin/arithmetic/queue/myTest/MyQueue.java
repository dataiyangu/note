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

    //判断是否满
    public static boolean isFull(MyQueue myQueue) {
        if ((myQueue.rear + 1)%myQueue.arrays.length == myQueue.front) {
            return true;
        } else {
            return false;
        }
    }

    //判断是否空
    public static boolean isEmpty(MyQueue myQueue) {
        if (myQueue.rear == myQueue.front) {
            return true;
        } else {
            return false;
        }
    }

    //入队
    public static void enQueue(MyQueue myQueue, int value) {
            myQueue.arrays[myQueue.rear] = value;
            myQueue.rear = (myQueue.rear + 1) % myQueue.arrays.length;
    }

    //出队
    public static void outQueue(MyQueue myQueue) {
        myQueue.front = (myQueue.front + 1) % myQueue.arrays.length;
    }

    //遍历
    public static void travers(MyQueue myQueue) {
        int front = myQueue.front;
        while (front!=myQueue.rear) {
            System.out.println(myQueue.arrays[front]);
            front++;
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(new int[6], 0, 0);
        System.out.println(isEmpty(myQueue)); //true

        enQueue(myQueue,1);
        enQueue(myQueue,2);
        enQueue(myQueue,3);
        enQueue(myQueue,4);
        enQueue(myQueue,5);

        System.out.println(isFull(myQueue));//true 因为有一个是浪费的

        travers(myQueue);//12345

        outQueue(myQueue);//1
    }
}
