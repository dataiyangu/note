package com.leesin.distributed.serializable;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/30 6:49
 * @version: ${VERSION}
 * @modified By:
 */
public class XStreamSerializer implements ISerializer {

    XStream xStream = new XStream(new DomDriver());
    @Override
    public <T> byte[] serialize(T obj) {
        return xStream.toXML(obj).getBytes();
    }

    @Override
    public <T> T deSerialize(byte[] data, Class<T> clazz) {
        return (T) xStream.fromXML(new String(data));
    }
}
