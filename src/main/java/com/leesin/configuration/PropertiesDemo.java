package com.leesin.configuration;

import java.io.IOException;
import java.util.Properties;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/5/15 0015 21:25
 * @modified By:
 */
public class PropertiesDemo {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        //能保存成key value形式的
        properties.setProperty("name", "leesin");
        properties.setProperty("aget", "18");
        //第一个参数output ，第二个参数注释 , 第三个参数 编码
        //能保存成xml格式的
        properties.storeToXML(System.out, "this is a commet","UTF-8");
    }
}
