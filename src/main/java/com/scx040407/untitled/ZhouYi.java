package com.scx040407.untitled;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ZhouYi {
    static final String STR = "XXXXXXXXXXX"; //在这里输入为何事求的卦
    static final int i1 = 111; //变动爻
    static final int i2 = 222; //上卦
    static final int i3 = 333; //下卦

    public static void main(String[] args) throws Exception {

        HashMap<String, String> gua = getGua64();

        int ii1 = i1 % 6 == 0 ? 6 : i1 % 6;
        int ii2 = i2 % 8 == 0 ? 8 : i2 % 8;
        int ii3 = i3 % 8 == 0 ? 8 : i3 % 8;
        String s2 = new Date().toLocaleString()
                + "\n"
                + STR;
        String s = s2
                + "\n变动爻: " + ii1
                + "\n上卦: " + ii2 +
                "\n下卦: " + ii3
                + "\n"
                + "----------------------"
                + "\n";
        System.out.println(s);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("zhouyi.txt", true));
            writer.write(s);
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static HashMap<String, String> getGua64() {
        HashMap<String, String> map = new HashMap<>();
        map.put("11","第一卦");
        map.put("22","第二卦");
        map.put("","第三卦");
        map.put("","第四卦");
        map.put("","第五卦");
        map.put("","第六卦");
        map.put("","第七卦");
        map.put("","第八卦");
        map.put("","第九卦");
        map.put("","第十卦");
        map.put("","第十一卦");
        map.put("","第十二卦");
        map.put("","第十三卦");
        map.put("","第十四卦");
        map.put("","第十五卦");
        map.put("","第十六卦");
        map.put("","第十七卦");
        map.put("","第十八卦");
        map.put("","第十九卦");
        map.put("","第二十卦");
        map.put("","第二十一卦");
        map.put("","第二十二卦");
        map.put("","第二十三卦");
        map.put("","第二十四卦");
        map.put("","第二十五卦");
        map.put("","第二十六卦");
        map.put("","第二十七卦");
        map.put("","第二十八卦");
        map.put("","第二十九卦");
        map.put("","第三十卦");
        map.put("","第三十一卦");
        map.put("","第三十二卦");
        map.put("","第三十三卦");
        map.put("","第三十四卦");
        map.put("","第三十五卦");
        map.put("","第三十六卦");
        map.put("","第三十七卦");
        map.put("","第三十八卦");
        map.put("","第三十九卦");
        map.put("","第四十卦");
        map.put("","第四十一卦");
        map.put("","第四十二卦");
        map.put("","第四十三卦");
        map.put("","第四十四卦");
        map.put("","第四十五卦");
        map.put("","第四十六卦");
        map.put("","第四十七卦");
        map.put("","第四十八卦");
        map.put("","第四十九卦");
        map.put("","第五十卦");
        map.put("","第五十一卦");
        map.put("","第五十二卦");
        map.put("","第五十三卦");
        map.put("","第五十四卦");
        map.put("","第五十五卦");
        map.put("","第五十六卦");
        map.put("","第五十七卦");
        map.put("","第五十八卦");
        map.put("","第五十九卦");
        map.put("","第六十卦");
        map.put("","第六十一卦");
        map.put("","第六十二卦");
        map.put("","第六十三卦");
        map.put("","第六十四卦");
        return map;
    }

}

