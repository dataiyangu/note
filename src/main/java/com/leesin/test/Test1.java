package com.leesin.test;

public class Test1 {
    public static A geta() {
        try {
            return new A();
        } catch (Exception e) {
            return null;
        }
        //return null;
    }
}
