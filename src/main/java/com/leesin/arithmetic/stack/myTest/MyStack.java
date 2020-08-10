package com.leesin.arithmetic.stack.myTest;

import com.leesin.arithmetic.list.ListNode;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/30 0030 18:49
 * @modified By:
 */
public class MyStack {

    public ListNode stackTop;
    public ListNode stackBottom;

    public MyStack(ListNode stackTop, ListNode stackBottom) {
        this.stackTop = stackTop;
        this.stackBottom = stackBottom;
    }



    //遍历
    public static void traverse(MyStack myStack) {
        ListNode stackTop = myStack.stackTop;
        while (stackTop != myStack.stackBottom) {
            System.out.print(stackTop.value);
            stackTop = stackTop.next;
        }
        System.out.println();
    }

    //是否为空
    public static boolean isEmpty(MyStack myStack) {
        if (myStack.stackTop == myStack.stackBottom) {
            return true;
        } else {
            return false;
        }
    }

    //进栈
    public static void pushStack(MyStack myStack,int value) {
        ListNode next = myStack.stackTop;
        myStack.stackTop = new ListNode(value);
        myStack.stackTop.next = next;
    }

    //出栈
    public static void popStack(MyStack myStack) {
        ListNode next = myStack.stackTop.next;
        myStack.stackTop =next;
    }

    //清空栈
    public static void clearStack(MyStack myStack) {
        myStack.stackTop = null;
        myStack.stackBottom = myStack.stackTop;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(new ListNode(0), new ListNode(0));
        myStack.stackBottom = myStack.stackTop;

        myStack.stackBottom = myStack.stackTop;

        System.out.println(isEmpty(myStack));//判断是否为空，true

        //入栈
        pushStack(myStack, 1);
        pushStack(myStack, 2);
        pushStack(myStack, 3);
        traverse(myStack);//3 2 1

        System.out.println(isEmpty(myStack));//判断是否为空，false

        popStack(myStack);//3 不输出了，没意义
        traverse(myStack);//21

        clearStack(myStack);
        System.out.println(isEmpty(myStack));//true
    }
}

