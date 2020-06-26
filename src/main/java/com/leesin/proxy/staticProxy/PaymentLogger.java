package com.leesin.proxy.staticProxy;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/26 0026 16:19
 * @modified By:
 */
public class PaymentLogger {
    public void log(String uid) {
        System.out.println(uid+"发起了支付行为，记录日志");
    }
}
