package com.scx040407.untitled;

/**
 * 枚举类
 *
 */
public enum Season {
    // 括号里面是说明信息
    SPRING(1),SUMMER(2),AUTUMN(3),WINTER(4);
    int seq;


    Season(int seq){
        this.seq = seq;
    }
}
