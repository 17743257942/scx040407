package com.scx040407.untitled.practice.InnerClassTest;

/**
 * �ӿ������ڲ���ʵ���˽ӿڣ��ô���ʵ�ֽӿڵ��������д������ʱ��������ѡ��һ�������ڲ��࣬һ�����Լ���д����
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
