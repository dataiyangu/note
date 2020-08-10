package com.leesin.arithmetic.queue;

import java.util.Stack;

/**
 * @description:两个栈实现一个队列
 * @author: Leesin Dong
 * @date: Created in 2020/6/30 0030 21:00
 * @modified By:
 */
//java中已经封装好了栈的类型，所以这里用java中封装好的
public class TwoStackOneQueue {
    //stackPush 压入 stackPop
    //总结：入队 push.add 出入 pop.push  pop.pop or pop.peek
    //【比较懒】
    //入队   入到第一个就完事了
    //出队，先入第二个，再从第二个出来
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public TwoStackOneQueue(Stack<Integer> stackPush, Stack<Integer> stackPop) {
        this.stackPush = stackPush;
        this.stackPop = stackPop;
    }


    /**
     * @description:队列add元素
     * @name: add
     * @param: value
     * @return: void
     * @date: 2020/6/30 0030 21:17
     * @auther: Administrator
    **/
    public  void push(int value) {
        // stackPush.add(value);//我感觉push方法也对
        stackPush.push(value);//stack的push add 方法一样的作用都是在栈顶添加元素，只不过返回值不一样
    }

    /**
     * @description: 出队操作 pop操作：每次取队列队首的元素，取出来 并弹出
     * @name: poll
     * @param:
     * @return: int
     * @date: 2020/6/30 0030 21:17
     * @auther: Administrator
    **/
    public int pop() {

        /*
        * Integer pop = stackPush.pop();
        stackPop.push(pop);
        Integer pop1 = stackPop.pop();
        * */


        //每次取队首的元素，把元素返回，并把元素取出来
        if (stackPush.isEmpty() && stackPop.isEmpty()) {//stackPush是空，并且stackPop也是空就不能操作
            throw new RuntimeException("Queue is empty");
        } else if (stackPop.isEmpty()) {//stackPop为空的时候才能把stackPush中的元素全部压入stackPop中，为了保证数据顺序性
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());//pop获取stackPush弹栈之后的数据，并且把数据弹出来了
            }
        }
        return stackPop.pop();//获取的是栈顶的元素，获取完会弹出
    }

    /**
     * @description: peek仅仅获取队首的元素，不会把队首的元素拿掉（弹出）
     * @name: peek
     * @param:
     * @return: int
     * @date: 2020/6/30 0030 21:24
     * @auther: Administrator
    **/
    public int peek() {
        if (stackPush.isEmpty() && stackPop.isEmpty()) {
            new RuntimeException("Queue is empty");
        } else if (stackPop.isEmpty()) {
            while (!stackPush.isEmpty()) {
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.peek();//获取栈顶元素，但是不弹出栈   这里唯一和上面不一样的
    }

    public static void main(String[] args) {
        TwoStackOneQueue queue = new TwoStackOneQueue(new Stack<Integer>(), new Stack<Integer>());
        //入队
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.peek());

        // System.out.println(queue.poll());//1
        // System.out.println(queue.poll());//2
        // System.out.println(queue.peek());//3
        // System.out.println(queue.peek());//3


    }

}
