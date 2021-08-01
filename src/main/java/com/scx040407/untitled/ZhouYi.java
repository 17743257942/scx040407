package com.scx040407.untitled;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ZhouYi {
    static final String STR = "XXXXXXXXXXX"; //在这里输入为何事求的卦
    static final int i1 = 1111456; //变动爻
    static final int i2 = 222233; //上卦
    static final int i3 = 3333456; //下卦

    public static void main(String[] args) throws Exception {

        HashMap<String, String> gua = getGua64();
        BufferedReader reader = new BufferedReader(new FileReader("64卦.txt"));
        int ii1 = i1 % 6 == 0 ? 6 : i1 % 6;
        int ii2 = i2 % 8 == 0 ? 8 : i2 % 8;
        int ii3 = i3 % 8 == 0 ? 8 : i3 % 8;
        String keyGua = gua.get(ii2 + "" + ii3); //获取卦名
        String keyGuaContent = ""; //卦的内容
        String line = "";
        while ((line = reader.readLine()) != null) {
            if (line.contains(keyGua)) {
                keyGuaContent += line + "\n";
                for (int i = 0; i < 10; i++) {
                    keyGuaContent += reader.readLine() + "\n";
                }
                keyGuaContent += "----------------------\n";
            }
        }
        String s2 = new Date().toLocaleString()
                + "\n"
                + STR;
        String s = s2
                + "\n" + keyGua
                + "\n变动爻: " + ii1
                + "\n" + keyGuaContent;  //卦和爻具体内容
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
        map.put("11", "第一卦");
        map.put("22", "第二卦");
        map.put("64", "第三卦");
        map.put("76", "第四卦");
        map.put("61", "第五卦");
        map.put("16", "第六卦");
        map.put("86", "第七卦");
        map.put("68", "第八卦");
        map.put("51", "第九卦");
        map.put("12", "第十卦");
        map.put("81", "第十一卦");
        map.put("18", "第十二卦");
        map.put("13", "第十三卦");
        map.put("31", "第十四卦");
        map.put("87", "第十五卦");
        map.put("48", "第十六卦");
        map.put("24", "第十七卦");
        map.put("75", "第十八卦");
        map.put("82", "第十九卦");
        map.put("58", "第二十卦");
        map.put("34", "第二十一卦");
        map.put("73", "第二十二卦");
        map.put("78", "第二十三卦");
        map.put("84", "第二十四卦");
        map.put("14", "第二十五卦");
        map.put("71", "第二十六卦");
        map.put("74", "第二十七卦");
        map.put("25", "第二十八卦");
        map.put("66", "第二十九卦");
        map.put("33", "第三十卦");
        map.put("27", "第三十一卦");
        map.put("45", "第三十二卦");
        map.put("17", "第三十三卦");
        map.put("41", "第三十四卦");
        map.put("38", "第三十五卦");
        map.put("83", "第三十六卦");
        map.put("53", "第三十七卦");
        map.put("32", "第三十八卦");
        map.put("67", "第三十九卦");
        map.put("46", "第四十卦");
        map.put("72", "第四十一卦");
        map.put("54", "第四十二卦");
        map.put("21", "第四十三卦");
        map.put("15", "第四十四卦");
        map.put("28", "第四十五卦");
        map.put("85", "第四十六卦");
        map.put("26", "第四十七卦");
        map.put("65", "第四十八卦");
        map.put("23", "第四十九卦");
        map.put("35", "第五十卦");
        map.put("44", "第五十一卦");
        map.put("77", "第五十二卦");
        map.put("57", "第五十三卦");
        map.put("42", "第五十四卦");
        map.put("43", "第五十五卦");
        map.put("37", "第五十六卦");
        map.put("55", "第五十七卦");
        map.put("22", "第五十八卦");
        map.put("56", "第五十九卦");
        map.put("62", "第六十卦");
        map.put("52", "第六十一卦");
        map.put("47", "第六十二卦");
        map.put("63", "第六十三卦");
        map.put("36", "第六十四卦");
        return map;
    }

}

