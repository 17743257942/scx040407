package com.scx040407.untitled.practice3.collection;

import com.scx040407.untitled.practice3.arrays.CountingGenerator;

public class MapDataTest {
    public static void main(String[] args) {
        System.out.println(MapData.map(new Letters(), 11));
        System.out.println(MapData.map(new CountingGenerator.Character(), new CountingGenerator.String2(),8));
        System.out.println(MapData.map(new CountingGenerator.Character(),"Value",6));
        System.out.println(MapData.map(new Letters(), new CountingGenerator.String2()));
        System.out.println(MapData.map(new Letters(), "pop"));

    }
}
