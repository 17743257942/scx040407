package _3_netty.netty.netty_demo;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.text.SimpleDateFormat;
import java.util.*;

public class HandlerServer extends SimpleChannelInboundHandler<String> {

//    public static List<Channel> channels = new ArrayList<>();
//    public static Map<String, Channel> channels2 = new HashMap<>();


    // channel组，管理所有channel
    // GlobalEventExecutor.INSTANCE 单例的全局事件执行器
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 建立连接时调用，通知上线
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("客户端 " + channel.remoteAddress() + " 加入聊天+++ " + sdf.format(new Date()) + "\n");
        channelGroup.add(channel);
    }

    /**
     * 断开连接时调用，通知下线
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("客户端 " + channel.remoteAddress() + " 离开了--- \n");
        System.out.println("channelGroup size [" + channelGroup.size() + "]");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端 " + ctx.channel().remoteAddress() + " 上线了... \n");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端 " + ctx.channel().remoteAddress() + " 离线... \n");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("发生了异常-------");
        ctx.close();
    }

    /**
     * 读取数据
     *
     * @param s
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String s) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.forEach(ch -> {
            if (channel != ch) {  //不是当前的ch，转发消息
                ch.writeAndFlush("客户" + channel.remoteAddress() + " 发送了消息 ： " + s + "\n");
            } else {
                ch.writeAndFlush("自己" + channel.remoteAddress() + " 发送了消息 ： " + s + "\n");
            }

        });

    }


}
