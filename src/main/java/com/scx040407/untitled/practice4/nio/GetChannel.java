package com.scx040407.untitled.practice4.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class GetChannel {
    private static final int BSIZE = 1024;

    public static void main(String[] args) throws Exception {
        FileChannel fc = new FileOutputStream("data.txt").getChannel();
        fc.write(ByteBuffer.wrap("some text,".getBytes()));
        fc.close();
        fc = new RandomAccessFile("data.txt", "rw").getChannel();
        fc.position(fc.size());
        fc.write(ByteBuffer.wrap("some more,".getBytes()));
        fc.close();

        fc = new FileInputStream("data.txt").getChannel();
        ByteBuffer buff = ByteBuffer.allocate(BSIZE);
        fc.read(buff);
        buff.flip();
//        while (buff.hasRemaining()) {
//            System.out.print((char) buff.get());
//        }

        System.out.println(buff.asCharBuffer());
//        System.setProperty("file.encoding","GBK");
        buff.rewind();
        String encoding = System.getProperty("file.encoding");
        System.out.println("Decode using " + encoding + ": " + Charset.forName(encoding)
                .decode(buff));

        System.out.println();
        //第一种 不好使
        fc = new FileOutputStream("data2.txt").getChannel();
        fc.write(ByteBuffer.wrap("some2 qwer,".getBytes()));
        fc.close();

        fc = new FileInputStream("data2.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());

        //第二种
        fc = new FileOutputStream("data3.txt").getChannel();
        buff = ByteBuffer.allocate(24);
        buff.asCharBuffer().put("askdlfjlk");
        fc.write(buff);
        fc.close();

        fc = new FileInputStream("data3.txt").getChannel();
        buff.clear();
        fc.read(buff);
        buff.flip();
        System.out.println(buff.asCharBuffer());
    }
}
