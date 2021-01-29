package week03.nio.timeServer;

import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {
    public static void main(String[] args) throws Exception {
        int port = 8080;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            Socket socket = null;

            while (true) {
                socket = server.accept(); //���̻߳�ȡ�ͻ�������
                new Thread(new TimeServerHandler(socket)).start(); //�����߳� �����߳�

            }
        } finally {

            if (server != null) {
                server.close();
                server = null;
            }
        }


    }


}
