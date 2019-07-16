package com.scx040407.untitled.practice.factory;

public class Factories {
    public static void serviceConsumer(ServiceFactory factory) {
        Service s = factory.getService();
        s.method1();
        s.method2();
    }

    public static void main(String[] args) {
        serviceConsumer(new ServiceImplFactory());
        serviceConsumer(new ServiceImpl2Factory());
    }


}
