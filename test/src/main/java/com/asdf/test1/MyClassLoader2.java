package com.asdf.test1;

import org.springframework.core.io.ClassPathResource;

import java.lang.reflect.Method;

public class MyClassLoader2 extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            ClassPathResource resource = new ClassPathResource("Hello.xlass");
            int length = (int) resource.contentLength();
            byte[] bytes = new byte[length];
            resource.getInputStream().read(bytes, 0, length);
            bytes = subByte255(bytes);
            return defineClass(name, bytes, 0, length);
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

    public static void main(String[] args) throws Exception {
        Class<?> clazz = new MyClassLoader2().findClass("Hello");
        System.out.println(clazz.getClassLoader());
        Method method = clazz.getMethod("hello");
        method.invoke(clazz.newInstance());
    }

}



