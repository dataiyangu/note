package com.leesin.arithmetic.stack.myTest;

import com.leesin.arithmetic.list.ListNode;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/30 0030 18:49
 * @modified By:
 */
public class MyStack {
    ListNode stackTop;
    ListNode stackBottom;

    public MyStack(ListNode stackTop, ListNode stackBottom) {
        this.stackTop = stackTop;
        this.stackBottom = stackBottom;
    }

    public static void pushStack(MyStack myStack, int value) {
        ListNode old = myStack.stackTop;
        ListNode node = new ListNode(value);
        myStack.stackTop = node;
        node.next = old;
    }

    public static void popStack(MyStack myStack) {
        myStack.stackTop = myStack.stackTop.next;
    }

    private static boolean isEmpty(MyStack myStack) {
        return true;
    }
    public static void traverse(MyStack myStack) {

    }
    public static void clearStack(MyStack myStack) {

    }


    public static void main(String[] args) {
        MyStack myStack = new MyStack(new ListNode(0), new ListNode(0));
        myStack.stackBottom = myStack.stackTop;

        myStack.stackBottom = myStack.stackTop;

        System.out.println(isEmpty(myStack));//判断是否为空，true

        //入栈
        pushStack(myStack,1);
        pushStack(myStack,2);
        pushStack(myStack,3);
        traverse(myStack);//3 2 1

        System.out.println(isEmpty(myStack));//判断是否为空，false

        popStack(myStack);//3

        clearStack(myStack);
        System.out.println(isEmpty(myStack));//true
    }
}

