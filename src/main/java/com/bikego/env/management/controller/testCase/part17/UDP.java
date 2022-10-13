package com.bikego.env.management.controller.testCase.part17;

import org.junit.Test;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.WebSocket;
import java.time.Duration;
import java.util.concurrent.CompletionStage;

public class UDP {

    /**
     * UDP协议是一种不可靠的网络协议，它在通信实例的两端各建立一个Socket，但这两个Socket之间并没有虚拟链路，这两个Socket只是 送、接收数据报的对象。
     * Java提供了DatagramSocket对象作为基于UDP协议的Socket，使用DatagramPacket代表DatagramSocket发送、接收的数据报。
     *
     * UDP协议是英文User Datagram Protocol的缩写，即用户数据报协议，主要用来支持那些需要在计算机之间传输数据的网络连接。UDP协议从问世至今已经被使用了很多年，
     * 虽然UDP协议目前应用不如TCP协议广泛，但UDP协议依然是一个非常实用和可行的网络传输层协议。尤其是在一些实时性很强的应用场景中，比如网络游戏、视频会议等，
     * UDP协议的快速更具有独特的魅力。
     *
     * UDP协议是一种面向非连接的协议，面向非连接指的是在正式通信前不必与对方先建立连接，不管对方状态就直接发送。至于对方是否可以接收到这些数据内容，UDP协议无法控制，
     * 因此说UDP协议是一种不可靠的协议。UDP协议适用于一次只传送少量数据、对可靠性要求不高的应用环境。因为UDP协议是面向非连接的协议，没有建立连接的过程，因此它
     * 的通信效率很高；但也正因为如此，它的可靠性不如TCP协议。
     *
     * 与前面介绍的TCP协议一样，UDP协议直接位于IP协议之上。实际上，IP协议属于OSI参考模型的网络层协议，而UDP协议和TCP协议都属于传输层协议。
     */

    /**
     * UDP协议和TCP协议简单对比如下
     * ➢ TCP协议：可靠，传输大小无限制，但是需要连接建立时间，差错控制开销大。
     * ➢ UDP协议：不可靠，差错控制开销较小，传输大小限制在64KB以下，不需要建立连接。
     */

    /**
     * Java使用DatagramSocket代表UDP协议的Socket，DatagramSocket本身只是码头，不维护状态，不能产生IO流，它的唯一作用就是接收和发送数据报，
     * Java 使用DatagramPacket来代表数据报，DatagramSocket接收和发送的数据都是通过DatagramPacket对象完成的。先看一下DatagramSocket的构造器。
     * ➢ DatagramSocket()：创建一个DatagramSocket实例，并将该对 象绑定到本机默认IP地址、本机所有可用端口中随机选择的某个端口。
     * ➢ DatagramSocket(int port)：创建一个DatagramSocket实例，并将该对象绑定到本机默认IP地址、指定端口。
     * ➢ DatagramSocket(int port, InetAddress laddr)：创建一个DatagramSocket实例，并将该对象绑定到指定IP地址、指定端口。
     */


    /**
     * 提示：当Client/Server程序使用UDP协议时，实际上并没有明显的服务器端和客户端，因为两方都需要先建立一个DatagramSocket对象，用来接收或发送数据报，
     * 然后使用DatagramPacket对象作为传输数据的载体。通常固定IP地址、固定端口的DatagramSocket对象所在的程序被称为服务器，因为该DatagramSocket可以主动接收客户端数据。
     */

    /**
     * MulticastSocket类是实现多点广播的关键，当MulticastSocket把一个DatagramPacket发送到多点广播IP地址时，该数据报将被自动广播到加入该地址的所有Multicast Socket。
     * MulticastSocket既可以将数据报发送到多点广播地址，也可以接收其他主机的广播信息。MulticastSocket有点像DatagramSocket，事实上MulticastSocket是DatagramSocket的一个子类，
     * 也就是说, MulticastSocket是特殊的DatagramSocket。当要发送一个数据报时, 可以使用随机端口创建MulticastSocket，也可以在指定端口创建MulticastSocket。
     */


    /**
     * ProxySelector代表一个代理选择器，它提供了对代理服务器更加灵活的控制，它可以对HTTP、HTTPS、FTP、SOCKS等进行分别设置，而且还可以设置不需要通过代理服务器的主机和地址。通过使用
     * ProxySelector，可以实现像在Internet Explorer、Firefox等软件中设置代理服务器类似的效果。
     */

    /**
     * 提示：代理服务器的功能就是代理用户去取得网络信息。当使用浏览器直接连接其他Internet站点取得网络信息时，通常需要先发送请求，然后等响应到来。代理服务器是介于浏览器和服务器之间的一台服务器，
     * 设置了代理服务器之后，浏览器不是直接向Web服务器发送请求，而是向代理服务器发送请求，浏览器请求被先送到代理服务器，由代理服务器向真正的Web服务器发送请求，并取回浏览器所需要的信息，再送回给浏览器。
     * 由于大部分代理服务器都具有缓冲功能，它会不断地将新取得的数据存储到代理服务器的本地存储器上，如果浏览器所请求的数据在它本机的存储器上已经存在而且是最新的，那么它就无须从Web服务器取数据，
     * 而直接将本地存储器上的数据送回浏览器，这样能显著提高浏览速度。归纳起来，代理服务器主要提供如下两个功能。
     * ● 突破自身IP限制，对外隐藏自身IP地址。突破IP限制包括访问国外受限站点，访问国内特定单位、团体的内部资源。
     * ● 提高访问速度，代理服务器提供的缓冲功能可以避免每个用户都直接访问远程主机，从而提高客户端访问速度。
     */

    /**
     * Java 11标准化的HTTP Client
     * 从Java 9开始引入孵化阶段的HTTP Client模块，经过Java 10的增强，Java 11正式标准化了HTTP Client模块。HTTP Client主要包含两个部分：
     * ① 用于发送基于HTTP协议的GET、POST、PUT、DELETE请求的HTTP Client部分；
     * ② 支持Web Socket的客户端API。
     *
     * 相比传统的HttpURLConnection，HTTP Client使用起来更方便，而且HTTP Client还支持现在流行的异步通信。通过HTTP Client的支持，可以方便地开发RESTful服务的客户端。
     * 使用HTTP Client发送请求的步骤如下。
     * ① 创建HttpClient对象。
     * ② 创建HttpRequest对象作为请求对象。如有需要，使用HttpRequest.BodyPublisher为请求本身添加请求参数。
     * ③ 调用HttpClient的send()或sendAsync()方法发送请求，其中sendAsync()方法用于发送异步请求。在调用这两个方法发送请求时，
     * 需要传入HttpResponse.BodyHandler对象，指定对响应数据进行转换处理。
     */
    @Test
    public void t0() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(20))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:3000/users/index"))
                .timeout(Duration.ofMinutes(2))
                .header("Content-Type","text/html")
                .GET()
                .build();

        HttpResponse.BodyHandler<String> bh = HttpResponse.BodyHandlers.ofString();

        HttpResponse<String> response = client.send(request,bh);

        System.out.println("响应的状态码: " + response.statusCode());
        System.out.println("响应头: " + response.headers());
        System.out.println("响应体: " + response.body());
//        响应的状态码: 500
//        响应头: java.net.http.HttpHeaders@63fef42f { {access-control-allow-origin=[*], connection=[keep-alive], content-length=[40], content-type=[application/json; charset=utf-8], date=[Tue, 12 Jul 2022 09:11:55 GMT], keep-alive=[timeout=5], vary=[Origin]} }
//        响应体: {
//            "code": 200,
//            "msg": "index page"
//        }
    }

    /**
     *  发送异步请求
     * 相比HttpURLConnection，HTTP Client支持发送异步请求。只要发送网络请求，就有可能存在网络延迟、等待服务器响应等时间开销。如果调用send()方法发送同步请求，在服务器响应到来之前，
     * 该方法不能返回，当前线程也会在该send()方法处阻塞—这就是同步请求的缺点；如果调用sendAsync()方法发送异步请求，该方法不会阻塞当前线程，程序执行了sendAsync()方法后会立即向下执行。
     * 程序使用sendAsync()方法发送请求后，该方法会立即返回一个CompletableFuture对象，它代表一个将要完成的任务--但具体何时完成，不确定。
     * 因此，程序要为CompletableFuture设置消费监听器，当CompletableFuture代表的任务完成时，该监听器就会被激发。
     */
    @Test
    public void t1() throws InterruptedException {
        CookieHandler.setDefault(new CookieManager());

        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(20))
                .cookieHandler(CookieHandler.getDefault())
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:3000/users/index"))
                .timeout(Duration.ofMinutes(2))
                .header("Content-Type","text/html")
                .GET()
                .build();

        client.sendAsync(request,HttpResponse.BodyHandlers.ofString())
                .thenApply(resp -> new Object[]{resp.statusCode(),resp.body()})
                .thenAccept(rt -> {
                    System.out.println("响应的状态码: " + rt[0]);
                    System.out.println("响应头: " + rt[1]);

                    client.sendAsync(request,HttpResponse.BodyHandlers.ofString())
                    .thenAccept(resp -> {
                        System.out.println("第二次异步响应的状态码: " + resp.statusCode());
                        System.out.println("第二次异步响应头: " + resp.body());
                    });
                });

        System.out.println("-----程序末端----");

        Thread.sleep(1000);
    }


    /**
     * sendAsync()方法发送异步的GET请求，该方法同样返回一个CompletableFuture对象。上面程序使用sendAsync()发送了两个异步请求，但这两个请求不会阻塞当前线程，
     * 因此运行该程序时将会看到先输出“--程序结束--”，然后才会输出POST请求的响应和GET请求的响应。上面程序中最后一行让当前线程暂停1000毫秒，这是因为本程序使用的是
     * sendAsync()方法发送异步请求的，而异步请求不会阻塞当前线程，因此程序会一直向下执行。如果没有这行暂停线程的代码，程序会执行完成，这样就无法看到服务器响应了（在服务器响应到来之
     * 前，程序已经执行结束）。
     */


    /**
     * WebSocket
     * WebSocket就像普通的Socket一样，只不过它是与Web应用之间建立的Socket连接，而且通常都是以异步方式进行通信的。
     * 通过Java来实现WebSocket客户端非常简单，只需如下两步即可。
     * ① 定义一个WebSocket.Listener对象作为监听器，根据需要重写该监听器中的指定方法。
     * ② 使用WebSocket.Listener对象作为监听器，使用WebSocketBuilder构建WebSocket客户端。
     */
    @Test
    public void t2() throws InterruptedException {
        WebSocket.Listener listener = new WebSocket.Listener() {
            @Override
            public void onOpen(WebSocket webSocket) {
                System.out.println("已打开连接");
                webSocket.sendText("我是java消息中心",true);
                webSocket.request(1);
            }

            @Override
            public CompletionStage<?> onText(WebSocket webSocket, CharSequence message, boolean last) {
                System.out.println(message);
                webSocket.request(1);
                return null;
            }
        };

        HttpClient client = HttpClient.newHttpClient();

        client.newWebSocketBuilder().buildAsync(URI.create("ws://127.0.0.1:8888/foo/simpleSocket"),listener);

        Thread.sleep(5000);
    }
}
