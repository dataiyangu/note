package com.leesin.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/25 0025 14:47
 * @modified By:
 */
public class HashMapDemo {
    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("a", "b");

        System.out.println("a".hashCode());
    }
}
