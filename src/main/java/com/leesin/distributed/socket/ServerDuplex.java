package com.leesin.distributed.socket;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/29 8:24
 * @version: ${VERSION}
 * @modified By:
 */
public class ServerDuplex {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket;
        InputStreamReader inputStreamReader;

        serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
        String s = in.readLine();
        System.out.println("client:" + s);

        String s1 = sin.readLine();
        while (!"bye".equals(s1)) {
            printWriter.println(s1);
            printWriter.flush();
            System.out.println("服务端："+s1);
            System.out.println("客户端："+in.readLine());
            s1 = sin.readLine();
        }
        in.close();
        sin.close();
        printWriter.close();
        socket.close();
        serverSocket.close();
    }

}
