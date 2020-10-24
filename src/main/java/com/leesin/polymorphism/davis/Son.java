package com.leesin.polymorphism.davis;

/**
 * @author: dongxueyuan
 * @date: Created in 2020/10/22 12:20 下午
 */

/**
* https://blog.csdn.net/fighting_sxw/article/details/79533910
 * 文中写的有部分问题，不是什么向上转型，通过评论中能够看到即使是 son 也是同样的效果：调用本身的，和多态没有本质的关系
 *
 * 原因：不论是Father father=new Son(); 、 Son son =new Son(); ，都是son本身，拥有父类的方法
 * public void doing(){
 *         talking();
 *     }
 * 父类的方法直接调用talking，而不是通过 "对象.talking()" 当前的指针，指向的是son本身，所以调用的是，son自己的
* */



public class Son extends Father{

    @Override
    public void talking() {
        System.out.println("Son is talking!");
    }
    public static void main(String[] args) {
        //Father father=new Son();
        //father.doing();
        Son son =new Son();
        son.doing();
    }
}
