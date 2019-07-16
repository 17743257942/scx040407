package com.scx040407.untitled.practice5.thread_monk;

import java.util.HashSet;
import java.util.Set;

/**
 * ��ͷ���ӣ���100����ͷ
 */
public class Box {
    private int count = 100;
    private Set<String> monks = new HashSet<>(); //ά��һ�����м�������ͳ���ù���ͷ�ĺ���

    public synchronized int getMantou(Monk m) {
        monks.add(m.getName());
        int mcount = m.getCount();

        // û����ͷ�˾ͷ���0
        if (count == 0) {
            return 0;
        }

        //������г���5���ˣ��͸������Ѿ��ﵽ���ݶ�
        if (mcount == Monk.MAX) {
            return -1;
        }

        //����һ�ξ�˵������һ����ͷ
        int curcount = count;
        count--;

        // ʣ���30����ͷ��Ϊ�˱�֤ÿ���˶��ܳԵ��������ù���ͷ�Ķ��ȴ�
//        if (count > 70) {
//            try {
//                this.wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        } else {
//            this.notifyAll();
//        }

        // �����ͷ��������û����ͷ�ĺ�����������Ҫ����ͷ��û���ù��ĺ���
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
