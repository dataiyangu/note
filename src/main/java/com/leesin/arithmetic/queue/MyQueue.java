package com.leesin.arithmetic.queue;

/**
 * @description: 数组时间静态队列
 * @author: Leesin Dong
 * @date: Created in 2020/6/30 0030 19:14
 * @modified By:
 */
public class MyQueue {
    //底层采用数组实现 （且循环队列）
    public int[] arrays;
    //好好理解下：front和rear之间的被视为队列（自己总结的不一定对）
    public int front;//指向第一个有效元素
    public int rear;//指向最后一个有效元素的下一个元素（无效元素） （数组有一个空间是浪费的）

    public MyQueue(int[] arrays, int front, int rear) {
        this.arrays = arrays;
        this.front = front;
        this.rear = rear;
    }

    /**
     * @description:  判断是否满
     * @name: isFull
     * @param: myQueue
     * @return: boolean
     * @date: 2020/6/30 0030 19:35
     * @auther: Administrator
    **/
    public static boolean isFull(MyQueue myQueue) {
        //rear指针的下一个节点如果指向了front指针就是满的
        //因为是循环的，所以这里取模
        if ((myQueue.rear + 1) % myQueue.arrays.length == myQueue.front) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @description: 判断是否是空
     * @name: isEmpty
     * @param: myQueue
     * @return: boolean
     * @date: 2020/6/30 0030 19:39
     * @auther: Administrator
    **/
    public static boolean isEmpty(MyQueue myQueue) {
        //当rear指针和front指针相等的时候，就是空，否则不空
        if (myQueue.rear == myQueue.front) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @description: 入队
     * @name: enQueue
     * @param: myQueue
     * @param: value
     * @return: void
     * @date: 2020/6/30 0030 19:41
     * @auther: Administrator
    **/
    public static void enQueue(MyQueue myQueue, int value) {
        //当不是满的时候才能入队
        if (!isFull(myQueue)) {
            //为什么？队尾入队，而且队尾有一个浪费的，这个浪费的就是用来入队的
            myQueue.arrays[myQueue.rear] = value;//rear指针指向的元素赋值为value
            myQueue.rear = (myQueue.rear + 1) % myQueue.arrays.length; //rear指针重新赋值一下
        }
    }

    /**
     * @description: 出队
     * @name: outQueue
     * @param: myQueue
     * @return: void
     * @date: 2020/6/30 0030 19:49
     * @auther: Administrator
    **/
    public static void outQueue(MyQueue myQueue) {
        if (!isEmpty(myQueue)) {//当队列不为空的时候才会出队
            int value = myQueue.arrays[myQueue.front]; //把出队的元素记录下 即front指向的元素
            System.out.println(value); //【出队了？没看到哇//其实front往后移动就是出队了，用front rear来表示整个队列，而不是数组 】
            //重新赋值front节点，因为出队了，所以front节点，也进行了变化，front节点往后移动一位
            myQueue.front = (myQueue.front - 1) % myQueue.arrays.length;
        }
    }

    /**
     * @description: 遍历
     * @name: tracerse
     * @param: myQueue
     * @return: void
     * @date: 2020/6/30 0030 19:45
     * @auther: Administrator
     **/
    public static void tracerse(MyQueue myQueue) {
        int i = myQueue.front;//i记录front
        while (i != myQueue.rear) {//front指针！= rear指针的时候遍历
            System.out.print(myQueue.arrays[i] + " ");
            i = (i + 1) % myQueue.arrays.length;//i指向下一个节点
        }
        System.out.println();
    }

    public static void main(String[] args) {
        //参数 数组、front指针、rear指针
        MyQueue myQueue = new MyQueue(new int[6], 0, 0);
        System.out.println(isEmpty(myQueue)); //true

        //入队
        enQueue(myQueue,1);
        enQueue(myQueue,2);
        enQueue(myQueue,3);
        enQueue(myQueue,4);
        enQueue(myQueue,5);

        System.out.println(isFull(myQueue));//true 因为有一个是浪费的

        tracerse(myQueue);//12345

        outQueue(myQueue);//1
    }
}
