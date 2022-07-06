package com.yitu32.io.file;

import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @ClassName Properties_
 * @Author yitu32
 * @Description
 * @Date 2022/7/4
 * @Version 1.0
 */
public class Properties_ {
    @Test
    public void test01(){
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src\\person.properties"));
            properties.list(System.out);
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");
            String age = properties.getProperty("age");
            System.out.println(username);
            System.out.println(password);
            System.out.println(age);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
