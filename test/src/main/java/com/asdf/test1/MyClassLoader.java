package com.asdf.test1;

import java.io.*;
import java.lang.reflect.Method;
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
        String path = "E:\\IdeaProjects\\scx040407\\test\\src\\main\\java\\com\\asdf\\test1\\Hello.xlass";
//        String path = "E:\\IdeaProjects\\scx040407\\test\\src\\main\\java\\com\\asdf\\test1\\Hello.class";
        File file = new File(path);
        try {
            byte[] bytes = getClassBytes(file);
            // for every byte do : 255 - byte
            byte[] result = subByte255(bytes);
            return defineClass(name, result, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private byte[] subByte255(byte[] bytes) {
        int length = bytes.length;
        byte[] result = new byte[length];
        for (int i = 0; i < bytes.length; i++) {
            result[i] = ((byte) (255 - bytes[i]));
        }
        return result;
    }

    private byte[] getClassBytes(File file) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        WritableByteChannel writableByteChannel = Channels.newChannel(byteArrayOutputStream);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true) {
            int i = fileChannel.read(byteBuffer);
            if (i == 0 || i == -1)
                break;
            byteBuffer.flip();
            writableByteChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        fileInputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static void main(String[] args) throws Exception {
//        Class<?> helloClass = new MyClassLoader().findClass("com.asdf.test1.Hello");
//        System.out.println(helloClass.getClassLoader()); //com.asdf.test1.MyClassLoader@1ee12a7
//        Method method = helloClass.getMethod("main", String[].class);
//        method.invoke(null, (Object) new String[]{""});
        Class<?> helloClass = new MyClassLoader().findClass("com.asdf.test1.Hello");
        System.out.println(helloClass.getClassLoader()); //com.asdf.test1.MyClassLoader@15fbaa4
        Method method = helloClass.getMethod("hello", null);
        method.invoke(helloClass.newInstance(), null); //Hello, classLoader!


    }
}
