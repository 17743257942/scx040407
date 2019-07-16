package com.scx040407.untitled.practice.InnerClassTest;

/**
 * 接口中用内部类实现了接口，好处是实现接口的类面对重写方法的时候有两种选择，一种是用内部类，一种是自己重写方法
 */
public class ClassInInterfaceImpl implements ClassInInterface {
    @Override
    public void howdy() {
        new Test().howdy();
    }

    public static void main(String[] args) {
        new ClassInInterfaceImpl().howdy();
        new Test().howdy();
    }


}
