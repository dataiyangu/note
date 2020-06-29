package com.leesin.spring;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/28 0028 11:14
 * @modified By:
 */
public class DemoFactory {
    public static final Demo getInstance() {
        return new Demo();
    }
}
