package com.leesin.serialize;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/27 0027 18:59
 * @modified By:
 */
public class User implements Serializable {
    private static final long serialVersionUID = -1736257663230356941L;

    private transient String sex;

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(sex);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        sex = (String)in.readObject();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
