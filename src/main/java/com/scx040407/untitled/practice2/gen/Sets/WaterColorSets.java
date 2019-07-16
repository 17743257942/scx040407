package com.scx040407.untitled.practice2.gen.Sets;

import java.util.EnumSet;
import java.util.Set;

import static com.scx040407.untitled.practice2.gen.Sets.Sets.*;
import static com.scx040407.untitled.practice2.gen.Sets.WaterColors.*;

public class WaterColorSets {
    public static void main(String[] args) {
        Set<WaterColors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
        Set<WaterColors> set2 = EnumSet.range(CURRENT_BLUE_HUE, BURNT_UMBER);
        System.out.println("set1: " + set1 + " " + set1.size());
        System.out.println("set2: " + set2 + " " + set2.size());
        System.out.println("union(set1,set2)::  " + union(set1, set2) + " " + union(set1, set2).size());
        System.out.println(WaterColors.values().length);

        Set<WaterColors> subset = intersection(set1, set2);
        System.out.println("subset: " + subset + " " + subset.size());

        System.out.println("difference(set1, subset):  " + difference(set1, subset) + " " + difference(set1, subset).size());
        System.out.println("difference(set2, subset):  " + difference(set2, subset) + " " + difference(set2, subset).size());
        System.out.println("complement(set1, set2):  " + complement(set1, set2) + " " + complement(set1, set2).size());
    }
}
