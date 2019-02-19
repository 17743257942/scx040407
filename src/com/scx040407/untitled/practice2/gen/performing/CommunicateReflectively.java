package com.scx040407.untitled.practice2.gen.performing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CommunicateReflectively {
    public static void perform(Object speaker) {
        Class<?> spkr = speaker.getClass();
        try {
            try {
                Method speak = spkr.getMethod("speak");
                speak.invoke(speaker);
            } catch (Exception e) {
                System.out.println(speaker + "cannot speak");
            }
            try {
                Method speak = spkr.getMethod("sit");
                speak.invoke(speaker);
            } catch (Exception e) {
                System.out.println(speaker + "cannot sit");
            }

        } catch (Exception e) {
            throw new RuntimeException(speaker.toString(), e);
        }
    }








}
