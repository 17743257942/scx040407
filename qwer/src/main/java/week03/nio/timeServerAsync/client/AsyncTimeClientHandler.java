package week03.nio.timeServerAsync.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

public class AsyncTimeClientHandler implements Runnable,
        CompletionHandler<Void, AsyncTimeClientHandler> {

    AsynchronousSocketChannel client;
    private String host;
    private int port;
    private CountDownLatch latch;

    public AsyncTimeClientHandler(String host, int port) {
        this.host = host;
        this.port = port;
        try {
            client = AsynchronousSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {
        latch = new CountDownLatch(1);
        client.connect(new InetSocketAddress(host, port), this, this);
        try {
            client.close();
        } catch (Exception e) {

        }
    }

    @Override
    public void completed(Void result, AsyncTimeClientHandler attachment) {

    }

    @Override
    public void failed(Throwable exc, AsyncTimeClientHandler attachment) {

    }
}
