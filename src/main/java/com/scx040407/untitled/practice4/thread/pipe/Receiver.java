package com.scx040407.untitled.practice4.thread.pipe;

import java.io.IOException;
import java.io.PipedReader;

/**
 * 2018/07/18 обнГ 10:18
 */
public class Receiver implements Runnable {
    private PipedReader in;

    public Receiver(Sender sender) throws IOException {
        this.in = new PipedReader(sender.getPipedWriter());
    }

    @Override
    public void run() {
        try {
            while (true) {
                    System.out.println("Read: "+ (char)in.read() + ", ");
            }
        }catch (IOException e) {
            System.out.println("Receiver read exception");
        }
    }
}
