package com.leesin.test;

import java.util.Map;

/**
 * @author: dongxueyuan
 * @date: Created in 2020/10/25 5:47 下午
 */
public class Test {
    public static void main(String[] args) {
        // Map<String, String> map = new HashMap<>();
        // get(map);
        // System.out.println(map.get(null));
        // System.out.println(map.get("2"));
        // Arrays.asList(",1".split(",")).forEach(i -> System.out.println("- " + i));
        // ArrayList list = new ArrayList();
        // list.add(1);
        // list.add(null);
        // list.add(2);
        // list.remove(null);
        // list.forEach(i -> System.out.println(i));

        // boolean b = false;
        // if (!b) {

        //     System.out.println("aaa");
        // }
        // if (b == false) {
        //     System.out.println("bbb");
        // }
        // String a = "";
        // a.length()
        char[] w = {'a', 'b'};
        // System.out.println(w.toString());
        // System.out.println(new String(w));
        String s = new String("a  b");
        String[] s1 = s.split(" ");
        for (int i = 0; i < s1.length; i++) {
            System.out.println("-" + s1[i] + "-");
        }

    }

    public static void get(final Map map) {
        map.put("1", "1");
    }

    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }

        int[] step = new int[n];
        step[0] = 1;
        step[1] = 2;
        for (int i = 2; i <= n; i++) {
            step[i % 3] = step[(i - 1) % 3] + step[(i - 2) % 3];
        }
        return step[(n - 1) % 3];
    }
}


