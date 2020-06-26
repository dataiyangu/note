package com.leesin.proxy.staticProxy;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/26 0026 16:21
 * @modified By:
 */
public class  ThridCHannelProxy implements Payment {

    private Payment payment = new ThridChannelPayment();
    PaymentLogger paymentLogger = new PaymentLogger();

    @Override
    public String dopay(String uid) {
        paymentLogger.log(uid);
        return payment.dopay(uid);
    }
}
