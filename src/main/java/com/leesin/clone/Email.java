package com.leesin.clone;

import java.io.Serializable;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/27 0027 16:38
 * @modified By:
 */
public class Email implements Serializable {
    private String content;

    public String getContent() {
        return content;
    }

    public Email(String content) {
        this.content = content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Email{" +
                "content='" + content + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
