package com.leesin.cglib;

import net.sf.cglib.beans.ImmutableBean;
import net.sf.cglib.proxy.*;

import java.lang.reflect.Method;

public class Test {
    public String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    //这里不能是static的
    public void out(){
        System.out.println("主方法");
    }
    public String out2(){
        return "123";
    }
    public static void main(final String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Test.class);
        enhancer.setCallback(new MethodInterceptor() {
            // @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before");
                Object o1 = methodProxy.invokeSuper(o, args);
                System.out.println("after");
                return o1;
            }
        });
        // Test o = (Test) enhancer.create();
        // o.out();

        enhancer.setCallback(new FixedValue() {
            public Object loadObject() throws Exception {
                return "Hello cglib";
            }
        });
        Test proxy = (Test) enhancer.create();
        System.out.println(proxy.out2()); //拦截test，输出Hello cglib
        System.out.println(proxy.toString());
        System.out.println(proxy.getClass());
        // System.out.println(proxy.hashCode());

    }
    // 有些时候我们可能只想对特定的方法进行拦截，对其他的方法直接放行，
    // 不做任何操作，使用Enhancer处理这种需求同样很简单,只需要一个CallbackFilter即可：
    public void testCallbackFilter() throws Exception{
        Enhancer enhancer = new Enhancer();
        CallbackHelper callbackHelper = new CallbackHelper(SampleClass.class, new Class[0]) {
            @Override
            protected Object getCallback(Method method) {
                if(method.getDeclaringClass() != Object.class && method.getReturnType() == String.class){
                    return new FixedValue() {
                        // @Override
                        public Object loadObject() throws Exception {
                            return "Hello cglib";
                        }
                    };
                }else{
                    return NoOp.INSTANCE;
                }
            }
        };
        enhancer.setSuperclass(SampleClass.class);
        enhancer.setCallbackFilter(callbackHelper);
        enhancer.setCallbacks(callbackHelper.getCallbacks());
        SampleClass proxy = (SampleClass) enhancer.create();
        // Assert.assertEquals("Hello cglib", proxy.test(null));
        // Assert.assertNotEquals("Hello cglib",proxy.toString());
        System.out.println(proxy.hashCode());
    }
    // 通过名字就可以知道，不可变的Bean。ImmutableBean允许创建一个原来对象的包装类，这个包装类是不可变的，
    // 任何改变底层对象的包装类操作都会抛出IllegalStateException。但是我们可以通过直接操作底层对象来改变包装类对象。这有点类似于Guava中的不可变视图
    // 为了对ImmutableBean进行测试，这里需要再引入一个bean
    public void testImmutableBean() throws Exception{
        Test bean = new Test();
        bean.setValue("Hello world");
        Test immutableBean = (Test) ImmutableBean.create(bean); //创建不可变类
        // Assert.assertEquals("Hello world",immutableBean.getValue());
        bean.setValue("Hello world, again"); //可以通过底层对象来进行修改
        // Assert.assertEquals("Hello world, again", immutableBean.getValue());
        immutableBean.setValue("Hello cglib"); //直接修改将throw exception
    }
}
