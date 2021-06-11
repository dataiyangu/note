package com.leesin.java8.stream;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.Builder;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://blog.csdn.net/u012881904/article/details/51325044
 * 和mysql group by一样的：多条件的笛卡尔积取出其中没有的数据行（其中的b甲就没有）
 */
public class groupBy {
    public static void main(String[] args) {
        Apple build1 = Apple.builder().name("a").level("甲").build();
        Apple build2 = Apple.builder().name("a").level("甲").build();
        Apple build3 = Apple.builder().name("a").level("甲").build();
        Apple build4 = Apple.builder().name("a").level("甲").build();
        Apple build5 = Apple.builder().name("a").level("乙").build();
        Apple build6 = Apple.builder().name("b").level("乙").build();
        Apple build7 = Apple.builder().name("b").level("乙").build();
        Apple build8 = Apple.builder().name("b").level("乙").build();

        ArrayList<Apple> apples = Lists.newArrayList(build1, build2,
                build3, build4, build5, build6, build7, build8);

        Map<String, List<Apple>> collect = apples.stream().collect(Collectors.groupingBy(item -> item.getName() + "-"
                + item.getLevel()));
        // System.out.println(collect);
        System.out.println('1' + "   "+  UUID.randomUUID().toString());
        System.out.println('2' + "   "+  UUID.randomUUID().toString());
        System.out.println('3' + "   "+  UUID.randomUUID().toString());
        System.out.println('4' + "   "+  UUID.randomUUID().toString());
        System.out.println('5' + "   "+  UUID.randomUUID().toString());
        System.out.println('6' + "   "+  UUID.randomUUID().toString());
        System.out.println('7' + "   "+  UUID.randomUUID().toString());
        System.out.println('8' + "   "+  UUID.randomUUID().toString());
        System.out.println('9' + "   "+  UUID.randomUUID().toString());
        System.out.println('0' + "   "+  UUID.randomUUID().toString());

        Object o = JSON.toJSONString("[]");
        System.out.println(o);

        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        map.put(1, list);
        System.out.println(map);
        System.out.println("=====");
        map.get(1).add(2);
        System.out.println(map);
    }



}
@Data
// @NoArgsConstructor
@Builder
class Apple {
    private String name;
    private String level;
}
