package com.leesin.qlExpress;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author Leesin Dong
 * @since Created in 2021/7/14 4:35 下午
 */
public class Test {
    public static void main(String[] args) {
        BigDecimal bigDecimal = BigDecimal.valueOf(1 / 10.0);
        System.out.println(bigDecimal);
        double v = bigDecimal.doubleValue();
        System.out.println(v);

        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 4);
        Integer integer = integers.stream().findFirst().map(i -> i.intValue()).orElse(null);
        System.out.println(integer);

    }
}
