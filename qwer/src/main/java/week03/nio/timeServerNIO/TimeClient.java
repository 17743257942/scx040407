package week03.nio.timeServerNIO;

public class TimeClient {
    public static void main(String[] args) {
        int port = 8080;
        new Thread(new TimeClientHandle("127.0.0.1", port),
                "TimeClient-0001").start();
    }
}