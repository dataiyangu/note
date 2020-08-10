package com.leesin.arithmetic.queue.myTest;

import java.util.Stack;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/30 0030 21:35
 * @modified By:
 */
public class TwoStackOneQueue {

    public static Stack<Integer> pushStack = new Stack<>();
    public static Stack<Integer> popStack = new Stack<>();

    public static void push(int value) {
        pushStack.push(value);
    }

    public static void pop(int value) {
        if (pushStack.isEmpty() || popStack.isEmpty()) {
            throw new RuntimeException();
        } else if (!pushStack.isEmpty()) {
            popStack.push(pushStack.pop());
        }
        popStack.pop();
    }

    public static void main(String[] args) {
        com.leesin.arithmetic.queue.TwoStackOneQueue queue = new com.leesin.arithmetic.queue.TwoStackOneQueue(new Stack<Integer>(), new Stack<Integer>());
        //入队
        queue.push(1);
        queue.push(2);
        queue.push(3);
        // System.out.println(queue.peek());
        // System.out.println(queue.poll());
        // System.out.println(queue.peek());

        System.out.println(queue.pop());//1
        System.out.println(queue.pop());//2
        System.out.println(queue.peek());//3
        System.out.println(queue.peek());//3
    }
}
