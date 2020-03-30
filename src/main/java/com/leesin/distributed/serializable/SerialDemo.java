package com.leesin.distributed.serializable;


/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/29 16:59
 * @version: ${VERSION}
 * @modified By:
 */
public class SerialDemo {
    public static void main(String[] args) {
        // ISerializer iSerializer = new JavaSerializerWriteFile();
        //xml格式方便阅读
        // ISerializer iSerializer = new XStreamSerializer();
        ISerializer iSerializer = new FastJsonSerilizer();

        User user = new User();
        user.setName("leesin");
        user.setAge(1);
        // User user = new User("leesin", 1);

        //序列化的时候 注释掉private static final long serialVersionUID = -2826403460911852878L;
        //反序列化的时候 打开  private static final long serialVersionUID = -2826403460911852878L;
        //会报错,说明不是一个serialVersionUID
        //说明即使不加这句话,也会默认生成一个UID,但是和通过idea生成的不一样,
        //序列化是通过serialVersionUID验证版本一致性的.

        //文件的不用传
        // iSerializer.serialize(user);
        // User user1 = iSerializer.deSerialize(null, null);
        // System.out.println(user1);

        //xml
        // byte[] bytes = iSerializer.serialize(user);
        // System.out.println(new String(bytes));
        // System.out.println(bytes.length);
        // User user1 = iSerializer.deSerialize(bytes, null);
        // System.out.println(user1);

        //json
        byte[] bytes = iSerializer.serialize(user);
        System.out.println(new String(bytes));
        System.out.println(bytes.length);
        User user1 = iSerializer.deSerialize(bytes, User.class);
        System.out.println(user1);
    }
}
