package com.scx040407.untitled.practice.InnerClassTest.withinner;

public class InheritInner extends WithInner.Inner {
    // Ҫͨ��xx.super�ķ�ʽ�ṩ��Ҫ������
    InheritInner(WithInner wi) {
        wi.super();
    }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
    }
}
