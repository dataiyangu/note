package com.leesin.exception;

import java.sql.SQLException;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/25 0025 19:14
 * @modified By:
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        //Demo
        // 接口 1 安全检查异常，2 拒绝登录异常  开放一些临时的用户做一些查询，想去改变密码的时候，抛出拒绝修改密码的异常，
        // 接口上增加了一个异常，导致这里抛出异常，需要再次catch
        //所以受检异常两个问题：
        //1 异常是主逻辑的补充逻辑，修改补充逻辑，导致主逻辑的修改，影响了代码的原则，实现类的变更影响调用者，破坏了封装行
        //2 调用一个方法，需要增加很多行代码做处理，降低代码的可读性

        //面试题，什么时候需要受检异常，什么时候不使用受检异常？

        //有这么多缺点，如何避免？
        //把受检异常转化为非受检异常 runtimeException ，这样就不需要对非受检异常 做处理
        //转化的原则：必须有一定的规范    IO、SQL 这种一定要处理，因为是底层的基础异常，不能把这些异常捕获掉，让用户无感知
        //这时候出现异常，用户是没有主观意识添加try catch捕获的
        //总结：
        //当受检异常威胁了系统的 安全性、稳定性、可靠性、正确性的时候，必须处理，不能转换成非受检异常，
        //其他情况可以转化成非受检异常
        IUser user = null;
        try {
            // 用户修改密码的操作       安全性异常，后来又需要加一个新的异常
            user.changePwd();
        } catch (SafeException e) {
            e.printStackTrace();   //第一次
        } catch (RejectException e) {
            e.printStackTrace();    //第二次又加了一个
        }


        //受检异常
        //必须被 1捕获 或者 2抛出去，不然报错，编译不通过
        try {
            throw new SQLException("sql Exception");
        } catch (SQLException throwables) {
            // 可以 close connection
            throwables.printStackTrace();
        }

        //非受检异常
        //不需要 1捕获 2抛出， 不报错
        throw new RuntimeException("运行时错误");


    }
}
//受检异常，非受检异常，都是在程序运行的时候出现的错误， 调用者接收到 非受检异常 时，什么都做不了 ，比如nullpointException
//当调用者接受到 受检异常的时候，知道哪里出问题了，比如IOException ，就可以在异常捕获里面做一些流的关闭

