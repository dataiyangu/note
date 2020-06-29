package com.leesin.serialize;

import java.io.*;

/**
 * @description:
 * @author: Leesin Dong
 * @date: Created in 2020/6/27 0027 18:59
 * @modified By:
 */
public class SerialDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        User user = new User();
        user.setName("mic");
        user.setSex("男");
        //序列化到流中
        // //序列化
        // // 把对象输入到输出流中，也可以写到文件里面，
        // ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        // ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        // objectOutputStream.writeObject(user);
        // byte[] bytes = byteArrayOutputStream.toByteArray();
        // //反序列化
        // //输入流读出
        // ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        // ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        // User user1 = (User) objectInputStream.readObject();
        // System.out.println(user1);

        //序列化到文件
        //序列化
        FileOutputStream fileOutputStream = new FileOutputStream(new File("user"));
        ObjectOutputStream objectOutputStream1 = new ObjectOutputStream(fileOutputStream);
        objectOutputStream1.writeObject(user);
        //反序列化
        FileInputStream fileInputStream = new FileInputStream(new File("user"));
        ObjectInputStream objectInputStream1 = new ObjectInputStream(fileInputStream);
        User user2 = (User) objectInputStream1.readObject();
        System.out.println(user2);


    }
}
