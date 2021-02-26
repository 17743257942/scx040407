package _3_netty.netty.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.HttpServerExpectContinueHandler;

public class HttpInitializer extends ChannelInitializer<SocketChannel> {
	
	@Override
	public void initChannel(SocketChannel ch) {
		ChannelPipeline p = ch.pipeline();
		//HttpServerCodec是netty针对http编解码的处理类，
		// 但是这些只能处理像http get的请求,也就是数据带在url问号后面的http请求
		//即 HttpRequestDecoder 和 HttpResponseEncoder 的结合
		p.addLast(new HttpServerCodec());
		//http 100-continue用于客户端在发送POST数据给服务器前，
		// 征询服务器情况，看服务器是否处理POST的数据，如果不处理，
		// 客户端则不上传POST数据，如果处理，则POST上传数据。在现实应用中，
		// 通过在POST大数据时，才会使用100-continue协议
		p.addLast(new HttpServerExpectContinueHandler());
		//当我们用POST方式请求服务器的时候，对应的参数信息是保存在message body中的
		//所以需要加上HttpObjectAggregator。
		p.addLast(new HttpObjectAggregator(1024 * 1024));
		//pipeline中添加处理类
		p.addLast(new HttpHandler());
	}
}
