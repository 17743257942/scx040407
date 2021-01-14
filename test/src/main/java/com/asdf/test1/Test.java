package com.asdf.test1;

import java.io.File;
import java.net.URISyntaxException;

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println(Test.class.getResource("").getPath().substring(1)
                .replace("target/classes", "src/main/java")
                .replace("/", "\\\\")); // E:\scx040407\test\src\main\java\com\asdf\test1\
    }
}
