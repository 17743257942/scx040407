package _3_netty.nio.timeServerNIO;


public class TimeServer {
    public static void main(String[] args) {
        int port=8080;
        MultiplexerTimeServer server = new MultiplexerTimeServer(port);
        new Thread(server,"NIO-MultiplexerTimeServer-001").start();
    }
}
