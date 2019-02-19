package com.scx040407.untitled.practice4.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class IOUtilTest1 {

    public static void readFile(String fileName) throws Exception {
        FileInputStream in = new FileInputStream(fileName);
        int b;
        int i = 1;

        while ((b = in.read()) != -1) {
            if (b <= 0xf) {
                System.out.print("0");
            }
            System.out.print(Integer.toHexString(b) + "  ");
            if (i++ % 10 == 0) {
                System.out.println();
            }
        }
    }

    public static void copyFile(File src, File dest) throws IOException {
        FileInputStream in = new FileInputStream(src);
        FileOutputStream out = new FileOutputStream(dest);
        byte[] buf = new byte[8 * 1024];
        int b;
        while ((b = in.read(buf, 0, buf.length)) != -1) {
            out.write(buf, 0, b);
            out.flush();//最好加上
        }
        in.close();
        out.close();
    }


}
