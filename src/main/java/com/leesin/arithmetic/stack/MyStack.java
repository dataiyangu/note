package com.leesin.arithmetic.stack;

import com.leesin.arithmetic.list.ListNode;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/30 0030 18:01
 * @modified By:
 */
public class MyStack {
    public ListNode stackTop;//栈顶
    public ListNode stackBottom;//栈底

    public MyStack(ListNode stackTop, ListNode stackBottom) {
        this.stackTop = stackTop;
        this.stackBottom = stackBottom;
    }

    /**
     * @description: 进栈
     * @name: pushStack
     * @param: myStack 栈
     * @param: value 进栈的数值
     * @return: void
     * @date: 2020/6/30 0030 18:04
     * @auther: Administrator
     **/
    public static void pushStack(MyStack myStack, int value) {
        ListNode node = new ListNode(value);//构建一个节点，把这个节点放入数据结构
        //stacktop 链表头 stackbottom 链表尾
        //相当于在头结点插入一个指针 头插
        node.next = myStack.stackTop;  //node.next - > 原来top
        myStack.stackTop = node;//新top->node
    }

    /**
     * @description: 遍历   实现：栈顶元素指针不指向栈底即可
     * @name: traverse
     * @param: myStack
     * @return: void
     * @date: 2020/6/30 0030 18:16
     * @auther: Administrator
     **/
    public static void traverse(MyStack myStack) {
        ListNode stackTop = myStack.stackTop;//获取栈顶元素的指针
        // 栈顶元素指针不指向栈底即可
        while (stackTop != myStack.stackBottom) {
            System.out.print(stackTop.value + " ");
            stackTop = stackTop.next;
        }
        System.out.println();
    }

    /**
     * @description: 判断栈是否为空
     * @name: isEmpty
     * @param: myStack
     * @return: boolean
     * @date: 2020/6/30 0030 18:20
     * @auther: Administrator
    **/
    public static boolean isEmpty(MyStack myStack) {
        //栈顶和栈底相等的时候为空
        if (myStack.stackTop == myStack.stackBottom) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * @description: 出栈
     * @name: popStack
     * @param:
     * @return: void
     * @date: 2020/6/30 0030 18:35
     * @auther: Administrator
    **/
    public static void popStack(MyStack myStack) {
        //栈不为空才出栈
        if (!isEmpty(myStack)) {
            //【不能把stacktop指针删掉，只要隔开就好了 stacktop-》stacktop.next】 直接指向它的下一个就好了
            ListNode stackTop = myStack.stackTop;
            myStack.stackTop = stackTop.next;
            System.out.println(stackTop.value);
        }
    }

    /**
     * @description: 清空栈
     * @name: clearStack
     * @param: myStack
     * @return: void
     * @date: 2020/6/30 0030 18:39
     * @auther: Administrator
    **/
    public static void clearStack(MyStack myStack) {
        //stackTop stackBottom都指向null
        myStack.stackTop = null;
        myStack.stackBottom = myStack.stackTop;
    }

    public static void main(String[] args) {
        //参数：栈顶指针、栈底指针
        MyStack myStack = new MyStack(new ListNode(0), new ListNode(0));
        //栈底指针指向栈顶指针
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
