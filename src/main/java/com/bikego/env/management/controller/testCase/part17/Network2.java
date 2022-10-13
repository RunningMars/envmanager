//package com.bikego.env.management.controller.testCase.part17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class Network2 {


    public static void main(String[] args) throws IOException {

        //每当接受到客户端Socket的请求时,服务器端也对应产生一个Socket
        Socket s = new Socket("127.0.0.1",3000);
        //....使用Socket进行通信了

        //将socket
        var br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String line = br.readLine();

        System.out.println("来自服务器的返回数据: " + line);

        br.close();
        s.close();
    }

}
