package com.scx040407.untitled.practice5.sourcecode;

import java.util.*;

/**
 * 2018/08/11 上午 10:32
 */
public class Collection implements Cloneable {
    public static void main(String[] args) {
        List list = new ArrayList();
        List list2 = new LinkedList();


        Set<String> set = new HashSet<>();


        Map<String, String> map = new HashMap();

        Collection c = new Collection();
        Collection c1 = (Collection) c.clone();
        System.out.println(c == c1);
        System.out.println(c);
        System.out.println(c1);

        int[] ii0 = {1, 2, 3, 4};
        int[] ii = new int[5];
        int[] ii2 = new int[]{1, 2, 3, 4, 5};

        ii2[2] = 55;
        for (int iii : ii2) {
            System.out.println(iii);
        }
        Stack stack = new Stack();


    }

    public Object clone() {
        Object o = null;
        try {
            o = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return o;
    }

    public void ff() {
        Object[] ii3;
    }

}
