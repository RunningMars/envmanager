//package com.bikego.env.management.controller.testCase.part17;//package com.bikego.env.management.controller.testCase.part17;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.charset.Charset;
import java.util.concurrent.Future;

public class SimpleAIOClient {

    static final int PORT = 30000;

    public static void main(String[] args)
    {
        ByteBuffer buff = ByteBuffer.allocate(1024);

        Charset utf = Charset.forName("utf-8");

        try (AsynchronousSocketChannel clientChannel = AsynchronousSocketChannel.open())
        {
            clientChannel.connect(new InetSocketAddress("127.0.0.1",PORT)).get();

            buff.clear();

            clientChannel.read(buff).get();

            buff.flip();

            String content = utf.decode(buff).toString();

            System.out.println("来自服务器的信息: " + content);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
