package com.leesin.basic;

import java.util.Objects;

/**
*  比较大小的三种方式
* */
public class EqualsDemo {

    public static final Integer a = 1;
    public static final Integer b = 1;

    public static final Integer o = 1;
    public static final Integer p = 2;

    public static final Integer c = 200;
    public static final Integer d = 200;

    public static final Integer e = 300;
    public static final Integer f = 200;

    public static final int g = 200;
    public static final int h = 200;

    public static final int i = 300;
    public static final int j = 200;

    public static final Integer k = 200;
    public static final int l = 200;

    public static final Integer m = 300;
    public static final int n = 200;

    /**
    * 综上所述：以后用Object.equals()\Objects.equals()效果是一样的，但是Object.equals()有空指针问题，所以以后
    *
    *  **不论是对象、包装类型、基本类型、包装类型基本类型混合用：都用Objects.equals()**
    * */
    public static void main(String[] args) {
        /*
        * Integer -128，127 相等不相等 三个都一样，所以不用管
        * */
        // true true true
        System.out.println("Integer a = 1  Integer b = 1");
        System.out.print((a == b )+ " ");
        System.out.print(a.equals(b)+ " ");
        System.out.print(Objects.equals(a,b)+ " ");
        System.out.println();
        System.out.println();
        // false false false
        System.out.println("Integer o = 1  Integer p = 2");
        System.out.print((o == p )+ " ");
        System.out.print(o.equals(p)+ " ");
        System.out.print(Objects.equals(o,p)+ " ");
        System.out.println();
        System.out.println();

        /*
        * Integer -128，127之外的 == 不能用，相等的时候，判断不相等，可以用c.equals(d)、Objects.equals
        * */
        // false true true
        System.out.println("Integer c = 200  Integer d = 200");
        System.out.print((c == d)+ " ");
        System.out.print(c.equals(d)+ " ");
        System.out.print(Objects.equals(c, d)+ " ");
        System.out.println();
        System.out.println();
        // false false false
        System.out.println("Integer e = 300  Integer f = 200");
        System.out.print((e == f)+ " ");
        System.out.print(e.equals(f)+ " ");
        System.out.print(Objects.equals(e, f)+ " ");
        System.out.println();
        System.out.println();


        /*
        * int的时候 相等不相等，三个的效果都是一样的
        * */
        // true true
        System.out.println("int g = 200 int h = 200");
        System.out.print((g == h)+ " ");
        //System.out.println(g.equals(h));
        System.out.print(Objects.equals(g, h)+ " ");
        System.out.println();
        System.out.println();
        // false false
        System.out.println("int i = 300 int j = 200");
        System.out.print((i == j)+ " ");
        //System.out.println(i.equals(j));
        System.out.print(Objects.equals(i, j)+ " ");
        System.out.println();
        System.out.println();


        /*
        * Integer和int混合的时候，integer会自动拆箱，相等不相等，三个效果都是一样的
        * */
        // true true true
        System.out.println("Integer k = 200  int l = 200");
        System.out.print((k == l)+ " ");
        System.out.print(k.equals(l)+ " ");
        System.out.print(Objects.equals(k,l)+ " ");
        System.out.println();
        System.out.println();
        // false false false
        System.out.println("Integer m = 300  int n = 200");
        System.out.print((m == n)+ " ");
        System.out.print(m.equals(n)+ " ");
        System.out.print(Objects.equals(m, n)+ " ");
        System.out.println();
        System.out.println();
    }


}
