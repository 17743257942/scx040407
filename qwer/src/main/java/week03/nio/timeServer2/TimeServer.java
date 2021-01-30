package week03.nio.timeServer2;

import week03.nio.timeServer.TimeServerHandler;

import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
    public static void main(String[] args) throws Exception {
        int port = 8080;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            Socket socket = null;
            TimeServerHandlerExecutePool singleExecutor = new TimeServerHandlerExecutePool(50,10000);
            while (true) {
                socket = server.accept(); //主线程获取客户端连接
                singleExecutor.execute(new TimeServerHandler(socket));

            }
        } finally {

            if (server != null) {
                server.close();
                server = null;
            }
        }


    }


}
