package com.leesin.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: dongxueyuan
 * @date: Created in 2020/10/25 5:47 下午
 */
public class Test {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        get(map);
        System.out.println(map.get(null));
    }

    public static void get(final Map map) {
        map.put("1", "1");
    }
}


