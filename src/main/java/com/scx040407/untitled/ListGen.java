package com.scx040407.untitled;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ListGen {
    static String s = "";
    static {
        StringBuffer ss = new StringBuffer();
        for (int i = 65; i < 65 + 26; i++) {
            char c = (char)i;
            ss.append(c);
        }
        for (int i = 97; i < 97 + 26; i++) {
            char c = (char)i;
            ss.append(c);
        }
        for (int i = 0; i < 10; i++) {
            ss.append(i);
        }
        s = ss.toString();
    }

    public static String getString(int length) {
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int j = 0; j < length; j++) {
            sb.append(s.charAt(r.nextInt(62)));
        }
        return sb.toString();
    }
    // 6位的随机字母加数字
    public static List<String> getList(int i) {
        List<String> array = new ArrayList<>();
        for (int count = 0; count < i; count++){
            array.add(getString(6));
        }
        return array;
    }

    public static List<String> getList2(int i) {
        List<String> array = new ArrayList<>();
        for (int count = 0; count < i; count++){
            array.add(getString(4));
        }
        return array;
    }


    public static void main(String[] args) {
        char a = 65+25;
        char b = 97+25;
        System.out.println(a);
        System.out.println(b);
        System.out.println(s+s.length());
        for (int k = 0; k < 10; k++) {
            Random r = new Random();
            int kk = r.nextInt(52);
            if ( kk > 51)
                System.out.println(kk);
        }
        List<String> arrs = getList(5);
        for (String s : arrs
                ) {
            System.out.println(s);
        }
        System.out.println(getString(8));

    }
}
