package com.leesin.test;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
public class Test {

    private static final String a = "";

    private static final boolean isA = true;

    private static final String POTENTIAL_BOSS_PRE = "POTENTIAL:BOSS:UID:";
    private static final Integer POTENTIAL_BOSS_QUANTITY = 3;
    private static final Integer LIST_FIRST = 0;
    private static final Integer PAGE_SIZE = 10;
    private static final Integer EMPTY_SIZE = 0;
    private static final Integer HOUR_COUNT = 24;

    public static void main(String[] args) {
        //Long money = null;
        //System.out.println(money * 1);
        //System.out.println(money * 1);

        //A a = null;

        //a.getLalala();

        //get(a);
        //if (geta() != null) {
        //System.out.println(Test1.geta().getLalala());
        //System.out.println(A.geta().getLalala());
        //System.out.println(geta().getLalala());
        //}

        //testNotNull(null);
        //BusGeologicalDrilling busGeologicalDrilling=new BusGeologicalDrilling();
        //Date date=new Date();
        //busGeologicalDrilling.setEnddt(date);
        //System.out.println(busGeologicalDrilling.getEnddt().toString());
        //date.setYear(5);
        //System.out.println(busGeologicalDrilling.getEnddt().toString());
        insert(1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2
                , 2, 2,
                2, 2, 2, 2, 2, 2, 2, 2, 2, 2);

    }

    public static void insert(int a, int b, int c, int d, int e, int f, int g, int h, int i, int j, int k, int l, int m, int n, int o, int p, int q, int r, int aa, int aaa, int bb, long ccc, long cc) {

    }

    public static void get(A a) {
        System.out.println(a.getLalala());
    }

    public static void testNotNull(@NotNull String input) {
        //Preconditions.checkNotNull(input);  //Guava will throw NullPointerException
        System.out.println("Hello, " + input);
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
