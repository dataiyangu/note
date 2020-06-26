package com.leesin.exception;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/25 0025 19:51
 * @modified By:
 */
public class SafeException extends Exception {
    public SafeException() {
        super();
    }

    public SafeException(String message) {
        super(message);
    }
}
