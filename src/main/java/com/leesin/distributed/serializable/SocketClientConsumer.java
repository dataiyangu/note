package com.leesin.distributed.serializable;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/29 16:34
 * @version: ${VERSION}
 * @modified By:
 */
public class SocketClientConsumer {
    public static void main(String[] args) throws IOException {
        Socket socket;
        socket = new Socket("localhost", 8080);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        // objectOutputStream.writeObject(new User("leesin",1));
        objectOutputStream.writeObject(new User());
        if (objectOutputStream != null) {
            objectOutputStream.close();
        }
        if (socket != null) {
            socket.close();
        }
    }

}
