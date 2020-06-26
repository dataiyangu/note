package com.leesin.proxy.DynamicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/26 0026 16:33
 * @modified By:
 */
public class DynamicProxy implements InvocationHandler {

    //被代理对象
    private Object target;

    //绑定目标对象
    public Object bind(Object target) {
        this.target = target;
        //this 实现invocationHandler的对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //调用之前
        System.out.println("记录日志开始");
        //反射调用真实的方法
        Object result = method.invoke(target, args);
        System.out.println("记录日志结束");
        return null;
    }
}
