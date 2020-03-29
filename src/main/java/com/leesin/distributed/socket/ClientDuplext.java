package com.leesin.distributed.socket;

import java.io.*;
import java.net.Socket;

/**
 * @description:
 * @author: Leesin.Dong
 * @date: Created in 2020/3/29 8:24
 * @version: ${VERSION}
 * @modified By:
 */
public class ClientDuplext {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost" , 8080);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        String s = sin.readLine();
        System.out.println("服务端："+s);
        while (!"bye".equals(s)) {
            printWriter.println(s);
            printWriter.flush();
            System.out.println("客户端："+s);
            System.out.println("服务端："+in.readLine());
            s = sin.readLine();
        }
        printWriter.close();
        sin.close();
        in.close();
        socket.close();
    }
}
