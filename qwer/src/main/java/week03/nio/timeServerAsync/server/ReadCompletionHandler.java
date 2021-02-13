package week03.nio.timeServerAsync.server;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.Date;

/**
 * Interface CompletionHandler<V,A>
 *
 * Type Parameters:
 * V - The result type of the I/O operation
 * A - The type of the object attached to the I/O operation
 *
 * example: V socket  A serverSocket
 * completed(AsynchronousSocketChannel result, AsyncTimeServerHandler attachment)
 */
public class ReadCompletionHandler implements CompletionHandler
        <Integer, ByteBuffer> {
    private AsynchronousSocketChannel channel;


    public ReadCompletionHandler(AsynchronousSocketChannel channel) {
        if (this.channel == null) {
            this.channel = channel;
        }

    }

    @Override
    public void completed(Integer result, ByteBuffer attachment) {
        attachment.flip();
        byte[] body = new byte[attachment.remaining()];
        attachment.get(body);
        try{
            String req = new String(body, "UTF-8");
            System.out.println("time server receive order : " + req);
            String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(req)
                    ? new Date(System.currentTimeMillis()).toString()
                    : "bad order";
            doWrite(currentTime);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private void doWrite(String currentTime) {
        byte[] bytes = currentTime.getBytes();
        ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
        writeBuffer.put(bytes);
        writeBuffer.flip();
        //This method initiates an asynchronous write operation to
        // write a sequence of bytes to this channel from the given buffer.
        //Parameters:
        //src - The buffer from which bytes are to be retrieved
        //attachment - The object to attach to the I/O operation; can be null
        //handler - The completion handler object
        channel.write(
                writeBuffer,
                writeBuffer,
                //A handler for consuming the result of an asynchronous I/O operation.
                new CompletionHandler<Integer, ByteBuffer>() {
                    @Override
                    public void completed(Integer result, ByteBuffer attachment) {
                        if (attachment.hasRemaining()) {
                            channel.write(attachment, attachment, this);
                        }
                    }

                    @Override
                    public void failed(Throwable exc, ByteBuffer attachment) {
                        try {
                            channel.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
        if (!writeBuffer.hasRemaining()) {
            System.out.println("Send order 2 server succeed");
        }
    }

    @Override
    public void failed(Throwable exc, ByteBuffer attachment) {
        try {
            this.channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
