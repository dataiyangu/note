package com.leesin.java8.wwj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wangwenjun on 2016/10/12.
 */
public class FilterApple {


    @FunctionalInterface
    public interface AppleFilter {

        boolean filter(com.wangwenjun.java8.Apple apple);

    }

    public static List<com.wangwenjun.java8.Apple> findApple(List<com.wangwenjun.java8.Apple> apples, AppleFilter appleFilter) {
        List<com.wangwenjun.java8.Apple> list = new ArrayList<>();

        for (com.wangwenjun.java8.Apple apple : apples) {
            if (appleFilter.filter(apple))
                list.add(apple);
        }
        return list;
    }

    public static class GreenAnd160WeightFilter implements AppleFilter {

        @Override
        public boolean filter(com.wangwenjun.java8.Apple apple) {
            return (apple.getColor().equals("green") && apple.getWeight() >= 160);
        }
    }

    public static class YellowLess150WeightFilter implements AppleFilter {

        @Override
        public boolean filter(com.wangwenjun.java8.Apple apple) {
            return (apple.getColor().equals("yellow") && apple.getWeight() < 150);
        }
    }

    public static List<com.wangwenjun.java8.Apple> findGreenApple(List<com.wangwenjun.java8.Apple> apples) {

        List<com.wangwenjun.java8.Apple> list = new ArrayList<>();

        for (com.wangwenjun.java8.Apple apple : apples) {
            if ("green".equals(apple.getColor())) {
                list.add(apple);
            }
        }

        return list;
    }

    public static List<com.wangwenjun.java8.Apple> findApple(List<com.wangwenjun.java8.Apple> apples, String color) {
        List<com.wangwenjun.java8.Apple> list = new ArrayList<>();

        for (com.wangwenjun.java8.Apple apple : apples) {
            if (color.equals(apple.getColor())) {
                list.add(apple);
            }
        }

        return list;
    }

    public static void main(String[] args) throws InterruptedException {
        List<com.wangwenjun.java8.Apple> list = Arrays.asList(new com.wangwenjun.java8.Apple("green", 150), new com.wangwenjun.java8.Apple("yellow", 120), new com.wangwenjun.java8.Apple("green", 170));
//        List<Apple> greenApples = findGreenApple(list);
//        assert greenApples.size() == 2;

       /* List<Apple> greenApples = findApple(list, "green");
        System.out.println(greenApples);

        List<Apple> redApples = findApple(list, "red");
        System.out.println(redApples);*/
/*
        List<Apple> result = findApple(list, new GreenAnd160WeightFilter());
        System.out.println(result);

        List<Apple> yellowList = findApple(list, new AppleFilter() {
            @Override
            public boolean filter(Apple apple) {
                return "yellow".equals(apple.getColor());
            }
        });

        System.out.println(yellowList);*/

        List<com.wangwenjun.java8.Apple> lambdaResult = findApple(list, apple -> apple.getColor().equals("green"));

        System.out.println(lambdaResult);

        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();


        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();


        Thread.currentThread().join();
    }


}
