package _5_spring.spring._6mybatis;

import org.apache.ibatis.io.Resources;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    public static void main(String[] args) throws Exception {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

    }
}
