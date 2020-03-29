package com.leesin.distributed.serializable;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/29 16:47
 * @version: ${VERSION}
 * @modified By:
 */
public interface ISerializer {
    <T> byte[] serialize(T obj);

    <T> T deSerialize(byte[] data , Class<T> clazz);
}
