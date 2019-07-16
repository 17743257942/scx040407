package com.scx040407.untitled.practice5.thread_monk;

import java.util.HashSet;
import java.util.Set;

/**
 * 馒头箱子，有100个馒头
 */
public class Box {
    private int count = 100;
    private Set<String> monks = new HashSet<>(); //维护一个和尚计数器，统计拿过馒头的和尚

    public synchronized int getMantou(Monk m) {
        monks.add(m.getName());
        int mcount = m.getCount();

        // 没有馒头了就返回0
        if (count == 0) {
            return 0;
        }

        //如果和尚吃了5个了，就告诉他已经达到最大份额
        if (mcount == Monk.MAX) {
            return -1;
        }

        //调用一次就说明拿了一个馒头
        int curcount = count;
        count--;

        // 剩最后30个馒头，为了保证每个人都能吃到，所以拿过馒头的都等待
//        if (count > 70) {
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        } else {
//            this.notifyAll();
//        }

        // 如果馒头数量等于没吃馒头的和尚数量，就要把馒头给没有拿过的和尚
        if (count == (30 - monks.size()) &&  monks.contains(m.getName())) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            this.notifyAll();
        }

        return curcount;
    }


}
