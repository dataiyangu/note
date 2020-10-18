package com.leesin.test;

import lombok.Getter;
import lombok.Setter;

public class Test {

    private static final String  a = "";

    public static void main(String[] args) {
        //Long money = null;
        //System.out.println(money * 1);
        //System.out.println(money * 1);

        //A a = null;

        //a.getLalala();

        //get(a);
        //if (geta() != null) {
        //System.out.println(Test1.geta().getLalala());
        System.out.println(A.geta().getLalala());
        //System.out.println(geta().getLalala());
        //}
    }

    public static void get(A a) {
        System.out.println(a.getLalala());
    }




    public static A geta() {
        try {
            return new A();
        } catch (Exception e) {
            return null;
        }
        //return null;
    }
}


@Getter
@Setter
class A {
    private String lalala;

    public static A geta() {
        try {
            return new A();
        } catch (Exception e) {
            return null;
        }
        //return null;
    }

}
