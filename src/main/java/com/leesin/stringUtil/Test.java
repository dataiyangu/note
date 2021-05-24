package com.leesin.stringUtil;


import org.apache.commons.lang3.StringUtils;

public class Test {
    public static void main(String[] args) {
        boolean blank = StringUtils.isBlank(null);
        System.out.println(blank);
    }
}
