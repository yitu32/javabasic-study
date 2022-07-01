package com.yitu32.io;

import org.junit.Test;

import java.io.*;

/**
 * @ClassName Convert_
 * @Author yitu32
 * @Description //TODO
 * @Date 2022/7/1
 * @Version 1.0
 */
public class Convert_ {

    @Test
    public void test01() {
        String utf8FilePath = "E:\\test\\test01.txt";
        String gbkFilePath = "E:\\test\\test02.txt";
        BufferedReader bufferedReader = null;
        try {
            // 如果不指定，默认当前项目编码
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(utf8FilePath),"utf-8"));
//            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(gbkFilePath), "gbk"));
            System.out.println(bufferedReader.readLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
