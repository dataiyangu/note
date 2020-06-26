package com.leesin.proxy.staticProxy;

import com.leesin.proxy.DynamicProxy.cglib.CglibDynamicProxy;
import net.sf.cglib.core.DebuggingClassWriter;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/26 0026 16:16
 * @modified By:
 */
public class ProxyDemo {
    public static void main(String[] args) {
        /*jdk*/

        /*DynamicProxy dynamicProxy = new DynamicProxy();
        Payment payment = new ThridChannelPayment();
        //                                                只需要传一个接口进去（本质是被代理类）
        Payment paymentProxy = (Payment) dynamicProxy.bind(payment);
        paymentProxy.dopay("mic");

        //输出出来，看下代理类到底是什么？
        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0", ThridChannelPayment.class.getInterfaces());
        String path = "PaymentProxy.class";
        //jdk7特性，不需要关闭流
        try (FileOutputStream fos = new FileOutputStream(path)) {
            fos.write(classFile);
            fos.flush();
            System.out.println("success");
        } catch (Exception e) {

        }*/

        //指定路径
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "code");

        /*cglib*/
        CglibDynamicProxy cglibDynamicProxy = new CglibDynamicProxy();
        ThridChannelPayment payment = new ThridChannelPayment();
        ThridChannelPayment tcp = (ThridChannelPayment) cglibDynamicProxy.getInstance(payment);
        System.out.println(tcp.dopay("mic"));


    }

    //这里没有用到代理
    // Payment payment = new ThridChannelPayment();
    // System.out.println(payment.dopay("MIC"));

    //支付之前做日志记录
}
