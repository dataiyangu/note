package com.leesin.distributed.socket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @description: 简单socket
 * @author: Leesin.Dong
 * @date: Created in 2020/3/29 8:06
 * @version: ${VERSION}
 * @modified By:
 */
public class client {
    public static void main(String[] args) throws IOException {
        Socket socket;
        PrintWriter printWriter;
        socket = new Socket("localhost",8080);
        printWriter = new PrintWriter(socket.getOutputStream(), true);
        printWriter.println("hi");
    }
}
