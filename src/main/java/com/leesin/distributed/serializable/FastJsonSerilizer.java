package com.leesin.distributed.serializable;

import com.alibaba.fastjson.JSON;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/30 7:07
 * @version: ${VERSION}
 * @modified By:
 */
public class FastJsonSerilizer implements ISerializer{
    public <T> byte[] serialize(T obj) {
        return JSON.toJSONString(obj).getBytes();
    }

    public <T> T deSerialize(byte[] data, Class<T> clazz) {
        return (T) JSON.parseObject(new String(data),clazz);
    }
}
