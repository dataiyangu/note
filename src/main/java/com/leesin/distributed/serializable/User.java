package com.leesin.distributed.serializable;

import java.io.IOException;
import java.io.Serializable;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/29 16:29
 * @version: ${VERSION}
 * @modified By:
 */
public class User implements Serializable {
    private static final long serialVersionUID = -2826403460911852878L;

    //这个字段不进行序列化,反序列化的时候会变成null
    private transient String name;
    private int age;

    //但是重写这两个方法之后，即使transient这个关键字之后，还是能够序列化的，但是方法名字不能变。
    //在ArrayList中也有类似的操作。这样可以保证序列化的时候是最小的最需要传输的对象
    private void writeObject(java.io.ObjectOutputStream s) throws IOException, ClassNotFoundException {
        s.defaultWriteObject();
        s.writeObject(name);
    }

    private void readObject(java.io.ObjectInputStream s)throws IOException,ClassNotFoundException {
        s.defaultReadObject();
        name = (String) s.readObject();
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // public User(String name, int age) {
    //     this.name = name;
    //     this.age = age;
    // }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
