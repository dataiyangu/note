package com.leesin.proxy.staticProxy;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/26 0026 16:15
 * @modified By:
 */
public class ThridChannelPayment implements Payment{
    @Override
    public String dopay(String uid) {
        System.out.println("uid->"+uid+"发起了支付操作");
        return "success";
    }
}
