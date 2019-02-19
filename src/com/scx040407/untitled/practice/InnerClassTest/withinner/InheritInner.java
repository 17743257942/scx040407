package com.scx040407.untitled.practice.InnerClassTest.withinner;

public class InheritInner extends WithInner.Inner {
    // 要通过xx.super的方式提供必要的引用
    InheritInner(WithInner wi) {
        wi.super();
    }

    public static void main(String[] args) {
        WithInner wi = new WithInner();
        InheritInner ii = new InheritInner(wi);
    }
}
