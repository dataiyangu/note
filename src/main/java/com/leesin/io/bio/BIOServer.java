package com.leesin.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/30 18:24
 * @version: ${VERSION}
 * @modified By:
 */
public class BIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int length = inputStream.read(bytes);
            if (length>0) {
                System.out.println("收到"+new String (bytes,0,length));
            }
        }

    }
}
