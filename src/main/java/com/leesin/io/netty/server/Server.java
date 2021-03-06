package com.leesin.io.netty.server;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) {


        //服务类
        // todo 1 serverBootstrap
        ServerBootstrap bootstrap = new ServerBootstrap();

        // todo 2 bossGroup workerGroup
        //boss线程监听端口，worker线程负责数据读写
        ExecutorService boss = Executors.newCachedThreadPool();
        ExecutorService worker = Executors.newCachedThreadPool();

        //设置niosocket工厂
        bootstrap.setFactory(new NioServerSocketChannelFactory(boss, worker));

        //设置管道的工厂，管道是服务，相当于装了一大堆的过滤器
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {

            @Override
            public ChannelPipeline getPipeline() throws Exception {
                // 3 todo pipelie.addLast 设置管道
                ChannelPipeline pipeline = Channels.pipeline();
                pipeline.addLast("decoder", new StringDecoder());
                pipeline.addLast("encoder", new StringEncoder());
                //接收消息
                pipeline.addLast("helloHandler", new HelloHandler());
                return pipeline;
            }
        });
        //绑定端口
        // todo 4 bootsTrap.bind
        bootstrap.bind(new InetSocketAddress(10101));

        System.out.println("start!!!");

        // todo 5 handler重写 messageRecived

    }

}
