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

            b.option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.TCP_NODELAY, true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.SO_REUSEADDR, true)
                    .childOption(ChannelOption.SO_RCVBUF, 32 * 1024)
                    .childOption(ChannelOption.SO_SNDBUF, 32 * 1024)
                    .childOption(EpollChannelOption.SO_REUSEPORT, true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);
            //把俩个工作线程组加入进来
            b.group(bossGroup, workerGroup)
                    //我要指定使用NioServerSocketChannel这种类型的通道
                    .channel(NioServerSocketChannel.class)

                    .handler(new LoggingHandler(LogLevel.INFO))
                    //一定要使用 childHandler 去绑定具体的 事件处理器
                    .childHandler(new HttpInitializer());
            //绑定指定的端口 进行监听 ChannelFuture f = b.bind(port).sync();
            Channel ch = b.bind(port).sync().channel();
            System.out.println("开启netty http服务器，监听地址和端口为 http://127.0.0.1:" + port + '/');
            //Thread.sleep(1000000); f.channel().closeFuture().sync();
            ch.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }


    }
}
