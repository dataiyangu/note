package com.leesin.distributed.serializable;

import java.io.*;

/**
 * @description: 抽象出方法
 * @author: Leesin.Dong
 * @date: Created in 2020/3/29 16:49
 * @version: ${VERSION}
 * @modified By:
 */
public class JavaSerializerWriteFile implements ISerializer {
    @Override
    public <T> byte[] serialize(T obj) {
        try {
            ObjectOutputStream objectOutputStream =
                    new ObjectOutputStream(new FileOutputStream(new File("user")));
            objectOutputStream.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    @Override
    public <T> T deSerialize(byte[] data, Class<T> clazz) {
        try {
            ObjectInputStream objectInputStream =
                    new ObjectInputStream(new FileInputStream(new File("user")));
            T t = (T) objectInputStream.readObject();
            return t;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
