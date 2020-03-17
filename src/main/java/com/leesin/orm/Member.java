package com.leesin.orm;

import lombok.Data;

import java.io.Serializable;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/3/7 11:42
 * @version:
 * @modified By:
 */
@Data
public class Member implements Serializable {
    private Long id;
    private String name;
    private String addr;
    private Integer age;
    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                ", age=" + age +
                '}';
    }
}


