package com.leesin.designmode.sigleton;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/7/3 0003 13:55
 * @modified By:
 */
public class HungrySingleton {
    private static final HungrySingleton instance = new HungrySingleton();

    private HungrySingleton(){}

    public static HungrySingleton getInstance() {
        return instance;
    }
}
