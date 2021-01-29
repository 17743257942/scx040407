package week03.timeServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class TimeServerHandler implements Runnable {
    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(this.socket.getOutputStream(), true);
            String currentTime = null;
            String body = null;
            while (true) {
                body = in.readLine();
                if (body == null) {
                    System.out.println("----body is null----");
                    break;
                }
                System.out.println("body=" + body);
                currentTime = body.contains("querytimeorder")
                        ? "====" + new Date(System.currentTimeMillis()).toString()
                        : "bad order";
//                System.out.println("currentTime=" + currentTime);
                out.println("HTTP/1.1 200 OK");
                out.println("Content-Type:text/html;charset=utf-8");
                out.println("Content-Length:" + body.getBytes().length);
                out.write(currentTime);
                out.println(currentTime);
            }

        } catch (Exception e) {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (out != null) {
                out.close();
            }
            if (this.socket != null) {
                try {
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                this.socket = null;
            }
        }
    }
}
