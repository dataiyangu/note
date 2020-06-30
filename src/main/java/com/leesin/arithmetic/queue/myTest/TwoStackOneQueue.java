package com.leesin.arithmetic.queue.myTest;

import java.util.Stack;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/30 0030 21:35
 * @modified By:
 */
public class TwoStackOneQueue {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStackOneQueue(Stack<Integer> stackPush, Stack<Integer> stackPop) {
        this.stackPush = stackPush;
        this.stackPop = stackPop;
    }

    public  void add(int value) {
        stackPush.add(value);
    }

    public int poll() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("Queue is enpty");
        } else if (!stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public int peek() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            throw new RuntimeException("Queue is enpty");
        } else if (!stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();
    }

    public static void main(String[] args) {
        com.leesin.arithmetic.queue.TwoStackOneQueue queue = new com.leesin.arithmetic.queue.TwoStackOneQueue(new Stack<Integer>(), new Stack<Integer>());
        //入队
        queue.add(1);
        queue.add(2);
        queue.add(3);
        // System.out.println(queue.peek());
        // System.out.println(queue.poll());
        // System.out.println(queue.peek());

        System.out.println(queue.poll());//1
        System.out.println(queue.poll());//2
        System.out.println(queue.peek());//3
        System.out.println(queue.peek());//3
    }
}
