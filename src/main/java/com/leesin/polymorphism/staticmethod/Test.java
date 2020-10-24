package com.leesin.polymorphism.staticmethod;

/**
 * @author: dongxueyuan
 * @date: Created in 2020/10/22 4:16 下午
 */

/**
 * https://blog.csdn.net/xtjatpsjkkk/article/details/9964281
 * 父类的方法和子类的方法是两个没有关系的方法，具体调用哪一个方法是看是哪个对象的引用
 * 静态的方法不能重写，也不能被重写。总之，静态的没有重写！！
 */
public class  Test {
    public static void main(String[] args) {
        M m = new N();
        //输出N
        //N.output();

        //输出M
        //M.output();

        //输出M，如果是多态的话，会是N，即不能重写
        //报错，不用管，能运行
        m.output();
    }
}

class M {
    public static void output() {
        System.out.println("M");
    }
}

class N extends M {
    public static void output() {
        System.out.println("N");
    }
}
