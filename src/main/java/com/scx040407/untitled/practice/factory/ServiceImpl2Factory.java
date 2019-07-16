package com.scx040407.untitled.practice.factory;

public class ServiceImpl2Factory implements ServiceFactory {
    @Override
    public Service getService() {
        return new ServiceImpl2();
    }
}
