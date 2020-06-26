package com.leesin.exception;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/25 0025 19:50
 * @modified By:
 */
public interface IUser {
    //用户修改密码的操作       安全性异常，后来又需要加一个新的异常
    void changePwd() throws SafeException,RejectException;
}

