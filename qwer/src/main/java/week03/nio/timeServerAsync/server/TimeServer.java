package week03.nio.timeServerAsync.server;


public class TimeServer {
    public static void main(String[] args) {
        int port=8080;
        AsyncTimeServerHandler server = new AsyncTimeServerHandler(port);
        new Thread(server,"AIO-AsyncTimeServerHandler-001").start();
    }
}
