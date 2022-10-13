package com.bikego.env.management.controller.testCase.part17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ChatServer {

    //定义保存所有Socket的ArrayList,并将其包装为线程安全的
    public static List<Socket> socketList = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws IOException {

        var ss = new ServerSocket(30000);

        while (true)
        {
            //此行代码会阻塞,将一直等待别人的连接
            Socket s = ss.accept();


            socketList.add(s);


            new Thread(new ServerThread(s)).start();
        }
    }

}

class ServerThread implements Runnable{

    Socket s = null;

    BufferedReader br = null;

    public ServerThread(Socket s ) throws IOException {
        this.s = s;
        br = new BufferedReader(new InputStreamReader(s.getInputStream()));
    }
    @Override
    public void run() {
        try{
            String content = null;

            while ( (content = readFromClient()) != null)
            {
                for (var s : ChatServer.socketList)
                {
                    var ps = new PrintStream(s.getOutputStream());
                    ps.println(content);
                }
            }
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    private  String readFromClient()
    {
        try{
            return br.readLine();
        }catch(IOException e)
        {
            ChatServer.socketList.remove(s);
        }
        return null;
    }
}
