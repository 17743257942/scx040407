package com.scx040407.untitled.practice4.thread.pipe;

import java.io.IOException;
import java.io.PipedWriter;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 2018/07/18 обнГ 10:02
 */
public class Sender implements Runnable {
    private Random rand = new Random(47);
    private PipedWriter pipedWriter = new PipedWriter();

    public PipedWriter getPipedWriter() {
        return pipedWriter;
    }

    @Override
    public void run() {
        try {
            while (true) {
                for (char c = 'A'; c <= 'z'; c++) {
                    pipedWriter.write(c);
                    TimeUnit.MILLISECONDS.sleep(rand.nextInt(500));
                }
            }
        } catch (IOException e) {
            System.out.println("Sender write exception");
        } catch (InterruptedException e) {
            System.out.println("Sender sleep interrupted");
        }
    }
}
