package com.scx040407.untitled.practice.factory;

public class ServiceImplFactory implements ServiceFactory {

    @Override
    public Service getService() {
        return new ServiceImpl1();
    }

}
