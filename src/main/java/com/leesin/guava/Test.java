package com.leesin.guava;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Leesin Dong
 * @since Created in 2021/7/14 3:37 下午
 */
public class Test {
    public static void main(String[] args) {
        Joiner joiner = Joiner.on(";");
        String str1 = joiner.join(new String[]{"a","b","c"});
        System.out.println(" str1 : " + str1);

        String join = joiner.join(Lists.newArrayList("a", "b", "c"));
        System.out.println(join);
    }
}
