package com.leesin.io.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @description:IO的操作过于繁琐，于是才有了Netty
 *  Netty就是对这一系列非常繁琐的操作进行了封装
 * @author: Leesin.Dong
 * @date: Created in 2020/3/30 18:33
 * @version: ${VERSION}
 * @modified By:
 */
public class NIOServerDemo {
    private int port = 8080;

    //准备两个东西
    //轮训器 大堂经理
    private Selector selector;
    //缓冲区 buffer等候区
    private ByteBuffer byteBuffer = ByteBuffer.allocate(1024);


    public NIOServerDemo(int port) throws IOException {
        this.port = port;
        //打开大门营业
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //银行地址
        serverSocketChannel.bind(new InetSocketAddress(port));

        //这个很关键,设置为非阻塞
        //BIO 升级版本 NIO，为了兼容BIO，NIO模型默认是采用阻塞式
        serverSocketChannel.configureBlocking(false);

        //轮训器打开,大堂经理开始营业
        selector = Selector.open();
        //将serverSocketChannel注册到selector,大堂经理到了大厅准备工作了.
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    public void listen() throws IOException {
        System.out.println("listen on "+port);
        //轮训主线程
        while (true) {
            //大唐经理在叫号
            selector.select();
            //每次都拿到所有的号
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            //不断的迭代，这就叫轮询
            //同步体现在这里,因为每次只能拿到一个key,每次只能处理同一种状态。
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();
                //每一个key代表一种状态
                //每一个号对应一个业务
                //数据就绪、数据刻度、数据可写等等。
                process(key);
            }
        }
    }

    //具体办业务的方法，坐班柜员
    //每一次轮询就是调用一次process方法，而每一次调用，只能干一件事
    //在同一时间点，只能干一件事
    private void process(SelectionKey key) throws IOException {
        //针对于每一种状态给一个反应
        if (key.isAcceptable()) {
            ServerSocketChannel server = (ServerSocketChannel) key.channel();
            //这个方法体现非阻塞，不管你数据有没有准备好
            //你给我一个状态和反馈
            SocketChannel channel = server.accept();
            //一定一定要记得设置为非阻塞
            channel.configureBlocking(false);
            //当数据准备就绪的时候，将状态改为可读
            channel.register(selector, SelectionKey.OP_READ);
        } else if (key.isReadable()) {
            //key.channel 从多路复用器中拿到客户端的引用
            SocketChannel channel = (SocketChannel) key.channel();
            int len = channel.read(byteBuffer);
            if (len>0) {
                String content = new String(byteBuffer.array(), 0, len);
                channel.register(selector, SelectionKey.OP_WRITE);
                //在key上携带一个附件，一会再写出去
                channel.configureBlocking(false);
                key.attach(content);
                System.out.println("读取内容："+content);
            }
        } else if (key.isWritable()) {
            SocketChannel channel = (SocketChannel) key.channel();
            channel.configureBlocking(false);
            String content = (String) key.attachment();
            channel.write(ByteBuffer.wrap(("输出："+content).getBytes()));
        }
    }

    public static void main(String[] args) throws IOException {
        new NIOServerDemo(8080).listen();
    }
}
