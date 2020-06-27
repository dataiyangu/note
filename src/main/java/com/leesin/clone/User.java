package com.leesin.clone;

import java.io.*;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/27 0027 16:25
 * @modified By:
 */

//Cloneable空接口 作用就是一种标志，表示当前的类重写了clone
//不加会报错
public class User implements  Cloneable,Serializable {
    private String name;

    private Email email;

    // public User() {
    // }
    //
    // public Email getEmail() {
    //     return email;
    // }
    //
    // public void setEmail(Email email) {
    //     this.email = email;
    // }
    //
    // public String getName() {
    //     return name;
    // }
    //
    // public void setName(String name) {
    //     this.name = name;
    // }
    //
    // @Override
    // public String toString() {
    //     return "User{" +
    //             "name='" + name + '\'' +
    //             '}';
    // }
    //
    // public User(String name) {
    //     this.name = name;
    // }
    // // public static void main(String[] args) throws CloneNotSupportedException {
    // //     User user = new User();
    // //     user.setName("mi");
    // //     User user1 = (User) user.clone();
    // //     System.out.println(user);
    // //     System.out.println(user1);
    // // }
    //
    // @Override
    // protected Object clone() throws CloneNotSupportedException {
    //     User user = (User) super.clone();
    //     user.setEmail((Email) email.clone());
    //     return user;
    // }


    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // public User() {
    // }

    public User(String name) {
        this.name = name;
    }

    public User deepClone() throws IOException, ClassNotFoundException {
        //把当前类序列化成字节码文件， 再反序列化
        //一读一写实现

        //1 把当前类写成一个序列化对象
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(this);
        //2 再去加载出来
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        return (User) ois.readObject();
    }
}
