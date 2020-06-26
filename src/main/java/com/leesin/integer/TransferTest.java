package com.leesin.integer;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/26 0026 11:15
 * @modified By:
 */
public class TransferTest {
    public static void main(String[] args) {
        Person person = new Person();
        System.out.println(person);
        System.out.println(person.a);
        change(person);
        System.out.println(person);
        System.out.println(person.a);
    }

    public static void change(Person p) {
        // p = new Person();
        p.set(5);
    }
}

/**
 * Person类
 */
class Person {
    Person1 p = new Person1();
    int a = 1;

    // public void set(Person1 a) {
    //     this.p= a;
    // }
    public void set(int a) {
        this.a= a;
    }
}

class Person1 {
    int a = 1;

    public void set(int a) {
        a = a;
    }
}