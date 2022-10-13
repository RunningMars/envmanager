package com.bikego.env.management.controller.testCase.part17;

import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.Future;

public class Network {

    /**
     * IP协议则是一种非常重要的通信协议。IP（Internet Protocol）协议又称互联网协议，是支持网间互联的数据报协议。
     *
     * TCP（ Transmission Control Protocol）协议，即传输控制协议，它规定一种可靠的数据信息传递服务。
     * 计算机网络分成物理层、数据链路层、网络层、传输层、会话层、表示层、应用层七层
     */

    /**
     * IP地址用于唯一地标识网络中的一个通信实体，这个通信实体既可以是一台主机，也可以是一台打印机，或者是路由器的某一个端口。
     */

    /**
     * 端口是一个16位的整数，用于表示数据交给哪个通信程序处理。因此，端口就是应用程序与外界交流的出入口，它是一种抽象的软件
     * 结构，包括一些数据结构和I/O（基本输入/输出）缓冲区。
     * 不同的应用程序处理不同端口上的数据，同一台机器上不能有两个程序使用同一个端口，端口号可以从0到65535，通常将它分为如下三类。
     * ➢ 公认端口（Well Known Ports）：从0到1023，它们紧密绑定Binding）一些特定的服务。
     * ➢ 注册端口（Registered Ports）：从1024到49151，它们松散地绑定一些服务。应用程序通常应该使用这个范围内的端口。
     * ➢ 动态和/或私有端口（Dynamic and/or Private Ports）：从49152到65535，这些端口是应用程序使用的动态端口，
     * 应用程序一般不会主动使用这些端口。
     */

    /**
     * Java提供了InetAddress类来代表IP地址，InetAddress下还有两个子类：Inet4Address、Inet6Address，
     * 它们分别代表Internet Protocol version 4（ IPv4 ）地址和Internet Protocol version 6（IPv6）地址。
     * InetAddress类没有提供构造器，而是提供了如下两个静态方法来获取InetAddress实例。
     * ➢ getByName(String host)：根据主机获取对应的InetAddress对象。
     * ➢ getByAddress(byte[] addr)：根据原始IP地址来获取对应的InetAddress对象。
     */

    /**
     * 使用www.google.com.hk搜索关键字“疯狂java”,浏览器地址栏所示的“乱码”—实际上这不是乱码，这就是所谓的 application/x-www-form-urlencoded MIME字符串。
     *
     * 当URL地址里包含非西欧字符的字符串时，系统会将这些非西欧字符串转换成乱码的特殊字符串编程过程中可能涉及普通字符串和这种特殊字符串的相关转换，这就需要使用URLDecoder和URLEncoder类。
     *
     * ➢ URLDecoder类包含一个decode(String s, String enc)静态方法，它可以将看上去是乱码的特殊字符串转换成普通字符串。
     * ➢ URLEncoder类包含一个encode(String s, String enc)静态方法，它可以将普通字符串转换成 application/x-www-formurlencoded MIME字符串。
     */

    /**
     * URL（Uniform Resource Locator）对象代表统一资源定位器，它是指向互联网“资源”的指针。资源可以是简单的文件或目录，也可
     * 以是对更为复杂对象的引用，例如对数据库或搜索引擎的查询。在通常情况下，URL可以由协议名、主机、端口和资源组成，即满足如下格式：
     * protocol://host:port/resourceName
     * URL类提供了多个构造器用于创建URL对象，一旦获得了URL对象之后，就可以调用如下方法来访问该URL对应的资源。
     * ➢ String getFile()：获取该URL的资源名。
     * ➢ String getHost()：获取该URL的主机名。
     * ➢ String getPath()：获取该URL的路径部分。
     * ➢ int getPort()：获取该URL的端口号。
     * ➢ String getProtocol()：获取该URL的协议名称。
     * ➢ String getQuery()：获取该URL的查询字符串部分。
     * ➢ URLConnection openConnection()：返回一个URLConnection对象，它代表了与URL所引用的远程对象的连接。
     * ➢ InputStream openStream()：打开与此URL的连接，并返回一个用于读取该URL资源的InputStream。
     */

    /**
     * 提示：
     * JDK中还提供了一个URI（Uniform Resource Identifiers）类，其实例代表一个统一资源标识符，Java的URI不能用于定位任何资源，
     * 它的唯一作用就是解析。与此对应的是，URL则包含一个可打开到达该资源的输入流，可以将URL理解成URI的特例。
     */


    /**
     * 基于TCP协议的网络编程
     * TCP/IP通信协议是一种可靠的网络协议，它在通信的两端各建立一个Socket，从而在通信的两端之间形成网络虚拟链路。一旦建立了虚拟的网络链路，两端的程序就可以通过虚拟链路进行通信。
     * Java对基于TCP协议的网络通信提供了良好的封装，Java使用Socket对象来代表两端的通信端口，并通过Socket产生IO流来进行网络通信。
     *
     * TCP协议被称作一种端对端协议。这是因为它对两台计算机之间的连接起了重要作用—当一台计算机需要与另一台远程计算机连接时，
     * TCP协议会让它们建立一个连接：用于发送和接收数据的虚拟链路。
     *
     * TCP协议负责收集这些信息包，并将其按适当的次序放好传送，接收端收到后再将其正确地还原。TCP协议保证了数据包在传送中准确无误。
     * TCP协议使用重发机制 -- 当一个通信实体发送一个消息给另一个通信实体后，需要收到另一个通信实体的确认信息，如果没有收到另一个通信实体的确认信息，则会再次重发刚才发送的信息。
     * 通过这种重发机制，TCP协议向应用程序提供了可靠的通信连接，使它能够自动适应网上的各种变化。即使在Internet暂时出现堵塞的情况下，TCP也能够保证通信的可靠性。
     */

    /**
     * 当ServerSocket使用完毕后，应使用ServerSocket的close()方法来关闭该ServerSocket。在通常情况下，服务器不应该只接收一个客户端请求，而应该不断地接收来自客户端的所有请求，
     * 所以Java程序通常会通过循环不断地调用ServerSocket的accept()方法。
     * Java中能接收其他通信实体连接请求的类是ServerSocket，ServerSocket对象用于监听来自客户端的Socket连接，如果没有连接，它将一直处于等待状态。ServerSocket包含一个监听来自客户端连接请求的方法。
     * ➢ Socket accept()：如果接收到一个客户端Socket的连接请求，该方法将返回一个与客户端Socket对应的Socket（如图
     * 17.4所示，每个TCP连接有两个Socket）；否则该方法将一直处于等待状态，线程也被阻塞。
     * 为了创建ServerSocket对象，ServerSocket类提供了如下几个构造器。
     * ➢ ServerSocket(int port)：用指定的端口port来创建一个ServerSocket。该端口应该有一个有效的端口整数值，即0～65535。
     * ➢ ServerSocket(int port, int backlog)：增加一个用来改变连接队列长度的参数backlog。
     * ➢ ServerSocket(int port, int backlog, InetAddress localAddr)：在机器存在多个IP地址的情况下，允许通过localAddr参数来指定将ServerSocket绑定到指定的IP地址。
     *
     * 当ServerSocket使用完毕后，应使用ServerSocket的close()方法来关闭该ServerSocket。在通常情况下，服务器不应该只接收一个客户端请求，而应该不断地接收来自客户端的所有请求，
     * 所以Java程序 通常会通过循环不断地调用ServerSocket的accept()方法。代码片段如下：
     */
    @Test
    public void t0() throws IOException {
        var ss = new ServerSocket(3000);

        while (true)
        {
            //每当接受到客户端Socket的请求时,服务器端也对应产生一个Socket
            Socket s = ss.accept();
            //....使用Socket进行通信了

            //将socket 对应的输出流包装成PrintStream
            var ps = new PrintStream(s.getOutputStream());

            ps.println("您好,您收到了服务器的祝福!");

            ps.close();
            s.close();
        }
    }

    /**
     * 提示：上面程序中创建ServerSocket没有指定IP地址，则该ServerSocket将会绑定到本机默认的IP地址。程序中使用30000作为该ServerSocket的端口号，
     * 通常推荐使用1024以上的端口，主要是为了避免与其他应用程序的通用端口冲突。
     */


    /**
     * 客户端通常可以使用Socket的构造器来连接到指定服务器，Socket通常可以使用如下两个构造器。
     * ➢ Socket(InetAddress/String remoteAddress, int port)：创建连接到指定远程主机、远程端口的Socket，该构造器没有指定本地地址、本地端口，
     * 默认使用本地主机的默认IP地址，默认使用系统动态分配的端口。
     * ➢ Socket(InetAddress/String remoteAddress, int port,InetAddress localAddr, int localPort)：创建连接到指定远程主机、远程端口的Socket，
     * 并指定本地IP地址和本地端口，适用于本地主机有多个IP地址的情形。
     */

    /**
     * 提示：如果读者学习过疯狂Java体系的《疯狂Ajax讲义》，那么对Ajax技术应该有一定印象。Ajax的关键在于异步请求：浏览器使用JavaScript发送异步请求—但异步请求的响应何时到来，
     * 程序无从知晓，因此程序会使用监听器来监听服务器端响应的到来。类似的，异步Channel发起IO操作后，IO操作由操作系统执行，IO操作何时完成，程序无从知晓，
     * 因此程序使用CompletionHandler对象来监听IO操作的完成。实际上，不仅AsynchronousServerSocketChannel的 accept()方法可以接受CompletionHandler监听器；
     * AsynchronousSocketChannel的read()、write()方法都有两个版本，其中一个版本需要接受CompletionHandler监听器。
     *
     * 通过上面介绍不难看出，使用AsynchronousServerSocketChannel只要三步。
     * ① 调用open()静态方法创建AsynchronousServerSocketChannel。
     * ② 调用AsynchronousServerSocketChannel的bind()方法让它在指定IP地址、端口监听。
     * ③ 调用AsynchronousServerSocketChannel的accept()方法接受连接请求。
     * 下面使用最简单、最少的步骤来实现一个基于AsynchronousServerSocketChannel的服务器端。
     */
}

