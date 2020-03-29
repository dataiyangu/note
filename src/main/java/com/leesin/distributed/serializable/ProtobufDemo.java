package com.leesin.distributed.serializable;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/29 17:50
 * @version: ${VERSION}
 * @modified By:
 */
public class ProtobufDemo {
    public static void main(String[] args) {
        UserProtos.User user = UserProtos.User.newBuilder().setAge(100000000).setName("leesin").build();
        byte[] bytes = user.toByteArray();
        for (byte bt : bytes) {
            System.out.print(bt+" ");
        }
    }
}
