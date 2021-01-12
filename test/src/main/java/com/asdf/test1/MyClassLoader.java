package com.asdf.test1;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.List;

public class MyClassLoader extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
//        String path = "E:\\study\\2021Java高级\\作业\\Hello.xlass";
//        String path = "E:\\IdeaProjects\\scx040407\\test\\src\\main\\java\\com\\asdf\\test1\\Hello.xlass";
        String path = "E:\\IdeaProjects\\scx040407\\test\\src\\main\\java\\com\\asdf\\test1\\Hello.class";
        File file = new File(path);
        try {
            byte[] bytes = getClassBytes(file);
            Class<?> c = this.defineClass(name, bytes, 0, bytes.length);
            return c;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return super.findClass(name);


//        return defineClass(name, bytes, 0, bytes.length);

    }

    private byte[] getClassBytes(File file) throws Exception {
        // 这里要读入.class的字节，因此要使用字节流
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel wbc = Channels.newChannel(baos);
        ByteBuffer by = ByteBuffer.allocate(1024);

        while (true) {
            int i = fc.read(by);
            if (i == 0 || i == -1)
                break;
            by.flip();
            wbc.write(by);
            by.clear();
        }

        fis.close();

        return baos.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        new MyClassLoader().findClass("Hello").newInstance();
    }
}
