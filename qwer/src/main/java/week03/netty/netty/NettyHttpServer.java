package week03.netty.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class NettyHttpServer {
    public static void main(String[] args) throws InterruptedException {

        int port = 8808;
        //1 第一个线程组 是用于接收Client端连接的
        EventLoopGroup bossGroup = new NioEventLoopGroup(2);
        //2 第二个线程组 是用于实际的业务处理操作的
        EventLoopGroup workerGroup = new NioEventLoopGroup(16);

        try {
            //3 创建一个辅助类Bootstrap，就是对我们的Server进行一系列的配置
            ServerBootstrap b = new ServerBootstrap();
            //Socket参数，服务端接受连接的队列长度，如果队列已满，客户端连接将被拒绝。默认值，Windows为200，其他为128。
            b.option(ChannelOption.SO_BACKLOG, 128)
                    // TCP参数，立即发送数据，默认值为Ture（Netty默认为True而操作系统默认为False）。
                    // 该值设置Nagle算法的启用，改算法将小的碎片数据连接成更大的报文来最小化所发送的报文的数量，
                    // 如果需要发送一些较小的报文，则需要禁用该算法。Netty默认禁用该算法，从而最小化报文传输延时
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    // Socket参数，连接保活，默认值为False。启用该功能时，TCP会主动探测空闲连接的有效性。
                    // 可以将此功能视为TCP的心跳机制，需要注意的是：默认的心跳间隔是7200s即2小时。
                    // Netty默认关闭该功能。
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    //ChanneOption.SO_REUSEADDR对应于套接字选项中的SO_REUSEADDR，
                    // 这个参数表示允许重复使用本地地址和端口，
                    //比如，某个服务器进程占用了TCP的80端口进行监听，此时再次监听该端口就会返回错误，
                    // 使用该参数就可以解决问题，该参数允许共用该端口，这个在服务器程序中比较常使用，
                    //比如某个进程非正常退出，该程序占用的端口可能要被占用一段时间才能允许其他进程使用，
                    // 而且程序死掉以后，内核一需要一定的时间才能够释放此端口，不设置SO_REUSEADDR
                    .childOption(ChannelOption.SO_REUSEADDR, true)
                    //ChannelOption.SO_SNDBUF参数对应于套接字选项中的SO_SNDBUF，
                    // ChannelOption.SO_RCVBUF参数对应于套接字选项中的SO_RCVBUF这两个参数用于操作接收缓冲区和发送缓冲区
                    .childOption(ChannelOption.SO_SNDBUF, 32 * 1024)
                    .childOption(ChannelOption.SO_RCVBUF, 32 * 1024)
                    //https://www.cnblogs.com/heroinss/p/9910977.html
                    // SO_REUSEPORT支持多个进程或者线程绑定到同一端口，提高服务器程序的性能
                    .childOption(EpollChannelOption.SO_REUSEPORT, true)
                    //  Netty参数，用于Channel分配接受Buffer的分配器，
                    //  默认值为AdaptiveRecvByteBufAllocator.DEFAULT，
                    //  是一个自适应的接受缓冲区分配器，能根据接受到的数据自动调节大小。
                    //  可选值为FixedRecvByteBufAllocator，固定大小的接受缓冲区分配器。
                    .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
            //把俩个工作线程组加入进来
            b.group(bossGroup, workerGroup)
                    //我要指定使用NioServerSocketChannel这种类型的通道
                    .channel(NioServerSocketChannel.class)
                    //打印出LoggingHandler中的日志 可以对入站\出站事件进行日志记录，从而方便我们进行问题排查。
                    .handler(new LoggingHandler(LogLevel.INFO))
                    //建立连接后做初始化工作 ；一定要使用 childHandler 去绑定具体的 事件处理器
                    .childHandler(new HttpInitializer());
            //启动server sync表示阻塞，启动是一个异步的过程，要等启动完才能执行下一步
            //绑定指定的端口 进行监听 ChannelFuture f = b.bind(port).sync();
            Channel ch = b.bind(port).sync().channel();
            System.out.println("开启netty http服务器，监听地址和端口为 http://127.0.0.1:" + port + '/');
            //wait until the server socket is closed; Thread.sleep(1000000); f.channel().closeFuture().sync();
            ch.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }


    }
}
