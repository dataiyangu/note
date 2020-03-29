package com.leesin.distributed.serializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/29 16:30
 * @version: ${VERSION}
 * @modified By:
 */
public class SocketServerProvider {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        User user = (User) objectInputStream.readObject();
        System.out.println(user);

        if (objectInputStream != null) {
            objectInputStream.close();
        }
        if (serverSocket != null) {
            serverSocket.close();
        }

    }
}
