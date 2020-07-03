package com.leesin.designmode.sigleton;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/7/3 0003 13:56
 * @modified By:
 */
public class LazySingleton {
    private static LazySingleton instance = null;

    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}

