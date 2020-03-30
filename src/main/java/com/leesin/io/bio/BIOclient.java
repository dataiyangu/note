package com.leesin.io.bio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/30 18:24
 * @version: ${VERSION}
 * @modified By:
 */
public class BIOclient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8080);
        OutputStream outputStream = socket.getOutputStream();
        String name = "leesin";
        outputStream.write(name.getBytes());
        if (outputStream != null) {
            outputStream.close();
        }
        if (socket != null) {
            socket.close();
        }
    }
}
