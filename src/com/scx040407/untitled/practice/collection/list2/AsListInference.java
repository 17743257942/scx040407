package com.scx040407.untitled.practice.collection.list2;

import com.sun.jmx.snmp.SnmpVarBindList;

import java.util.*;

public class AsListInference {
    public static void main(String[] args) {
        // list1是Arrays生成的，不能改变长度
        List<Snow> list1 = Arrays.asList(new Crusty(), new Slush(), new Powder());
        List<Snow> list2 = Arrays.asList(new Light(), new Heavy());
        Light l = new Light();
        Crusty c = new Crusty();
        Snow s = new Snow();
        Collections.addAll(list1);
        System.out.println(list1.size());

        List<Snow> list3 = new ArrayList<>();
        Collections.addAll(list3, l, c, s);
        System.out.println(list3.size());

        List<Snow> list4 = Arrays.asList(new Snow(), new Heavy());
        System.out.println(list4.size());
    }
}
