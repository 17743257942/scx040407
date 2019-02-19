package com.scx040407.untitled.practice.state;

public class Stage {
    private Actor act = new Actor2();
    public void change(){
        act = new Actor3();
    }
    public void play(){
        act.act();
    }

}
