package com.scx040407.untitled.practice3.arrays;

import com.sun.jndi.ldap.Ber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContainerComparison {
    public static void main(String[] args) {
        BerylliuSphere[] spheres = new BerylliuSphere[10];
        for (int i = 0; i < 5; i++) {
            spheres[i] = new BerylliuSphere();
        }
        System.out.println(Arrays.toString(spheres));
        System.out.println(spheres[4]);

        List<BerylliuSphere> sphereList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            sphereList.add(new BerylliuSphere());
        }
        System.out.println(sphereList);
        System.out.println(sphereList.get(4));

        int[] integers = {0, 1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(integers));
        System.out.println(integers[4]);

        List<Integer> intList = new ArrayList<Integer>(
                Arrays.asList(0, 1, 2, 3, 4, 5)
        );
        intList.add(97);
        System.out.println(intList);
        System.out.println(intList.get(4));

        // new Instance 数组的初始化
        System.out.println("-----------------");
        BerylliuSphere[] a;
        BerylliuSphere[] b = new BerylliuSphere[5];
        System.out.println("b: " + Arrays.toString(b));
        BerylliuSphere[] c = new BerylliuSphere[4];
        for (int i = 0; i < c.length; i++) {
            if (c[i] == null) {
                c[i] = new BerylliuSphere();
            }
        }
        BerylliuSphere[] d = {new BerylliuSphere(), new BerylliuSphere(), new BerylliuSphere()};
        a = new BerylliuSphere[]{new BerylliuSphere(), new BerylliuSphere()};
        System.out.println("a.len " + a.length);
        System.out.println("d.len " + d.length);
        a = d;
        System.out.println("a.len " + a.length);
        Character[] chars = new Character[4];
        for (Character cc : chars) {
            System.out.println("cc: " + cc);
        }
        String[] strings = new String[3];
        for (String ss : strings) {
            System.out.println("ss: " + ss);
        }
    }
}
