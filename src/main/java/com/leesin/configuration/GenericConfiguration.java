package com.leesin.configuration;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/5/15 0015 20:43
 * @modified By:
 */
public class GenericConfiguration {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.age","0"));
        //将System Properties 转换为Integer类型
        System.out.println(Integer.getInteger("user.age",0));
        System.out.println(Boolean.getBoolean("user.male"));
    }
}
