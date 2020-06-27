package com.leesin.classloader.egme;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/27 0027 12:32
 * @modified By:
 */
//https://blog.csdn.net/qq_33699659/article/details/84864055
class Father {
    //静态代码块
    static {
        // System.out.println(str1);
        System.out.println("父类的静态代码块1");
    }
    //静态属性
    public static String str1= Write.wirte("父类中的静态属性");
    //普通属性
    public String str2 = Write.wirte("父类中的普通属性1");
    public String str22 = Write.wirte("父类中的普通属性2");
    public String str222 = Write.wirte("父类中的普通属性3---从上往下");
    //无参构造方法
    public Father(){
        System.out.println("父类的无参构造方法---只有一个");
        System.out.println("------父类--------普通属性从上玩下->构造代码块从上往下->一个无参构造------------------如果调用父类构造，到这里结束后面不走");

    }

    //有参构造方法
    public Father(int a ) {
        System.err.println("父类的有参构造方法"+a);
    }
    //静态代码块
    static {
        // System.out.println(str1);
        System.out.println("父类的静态代码块2");
        System.out.println("------父类--------静态代码块、静态属性 混合从上玩下------------------");
    }
    //构造代码块
    {
        // System.out.println(str2);
        System.out.println("父类的构造代码块1");
    }

    //构造代码块
    {
        // System.out.println(str2);
        System.out.println("父类的构造代码块2---从上往下");
    }
}

class Son extends Father{
    //子类中的静态代码块
    static {
        // System.out.println(str1);
        System.out.println("子类中的静态代码块1");
    }
    //子类中的静态属性
    public static String str1 = Write.wirte("子类中的静态属性");
    //子类中的普通属性
    public String str2 = Write.wirte("子类中的普通属性1");
    public String str22 = Write.wirte("子类中的普通属性2");
    public String str222 = Write.wirte("子类中的普通属性3---从上往下");
    //子类中的无参构造方法
    public Son() {
        System.out.println("子类中的无参构造方法---只有一个");
        System.out.println("------子类--------普通属性从上玩下->构造代码块从上往下->一个无参构造------------------");
    }
    //子类中的有参构造方法
    public Son(int a ) {
        //super(a);
        System.out.println("子类中的有参构造方法---没有加载无参构造");
        System.out.println("------子类--------普通属性从上玩下->构造代码块从上往下->一个有参构造 + 构造方法用哪个，加载哪个------------------");
    }

    //子类中的有参构造方法
    public Son(int a,int b ) {
        //super(a);
        System.out.println("子类中的有参构造方法"+a);
    }

    //子类中的静态代码块
    static {
        // System.out.println(str1);
        System.out.println("子类中的静态代码块2");
        System.out.println("------子类--------静态代码块、静态属性 混合从上玩下------------------");
    }
    //子类中的构造代码块
    {
        // System.out.println(str2);
        System.out.println("子类中的构造代码块1");
    }

    //构造代码块
    {
        // System.out.println(str2);
        System.out.println("子类的构造代码块2---从上往下");
    }
}

public class Test {
    public static void main(String[] args) {
        System.out.println("=============第一次调用有参构造================");
        Son s = new Son();
        System.out.println("=============第二次调用有参构造================");
        System.out.println("------父类--------静态代码块、静态属性 没了------------------");
        System.out.println("------子类--------静态代码块、静态属性 没了------------------");
        Son a = new Son(5);
        System.out.println("=====================后面不用看了，mian方法在栈中从上往下执行=====================");
        System.out.println("main方法中的函数1");
        {
            System.out.println("main方法中的普通代码块1");
        }
        System.out.println("main方法中的函数2");
        {
            System.out.println("main方法中的普通代码块2");
        }
    }
    static {
        System.out.println("主类中的静态代码块1");
    }
    static String a = Write.wirte("主类中的静态属性");
    static {
        System.out.println("主类中的静态代码块2");
        System.out.println("------主类--------静态代码块、静态属性 从上往下------------------");
        System.out.println("------主类--------普通属性、静态方法、构造方法 都不走------------------");
    }
    String b = Write.wirte("主类中的普通属性");

    public Test(String b) {
        System.out.println("主类中构造方法");
    }

    {
        System.out.println("主类 构造代码块");
    }
}

