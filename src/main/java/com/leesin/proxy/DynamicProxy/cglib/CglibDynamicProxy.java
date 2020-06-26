package com.leesin.proxy.DynamicProxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/26 0026 16:33
 * @modified By:
 */
public class CglibDynamicProxy implements MethodInterceptor {

    //代理的业务类对象，可是接口，可以是类
    private Object target;

    //获得代理的实例
    public Object getInstance(Object target) {
        this.target = target;
        //加强器，用来创建动态代理
        Enhancer enhancer = new Enhancer();
        //为加强器指定业务代理类，也就是为代理类指定父类
        //enhancer 真正被代理类的 子类
        enhancer.setSuperclass(this.target.getClass());
        //回调，调用当前类的intercept方法
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //调用之前
        System.out.println("记录日志开始");
        //反射调用真实的方法 , 即父类的方法
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("记录日志结束");
        return null;
    }
}
