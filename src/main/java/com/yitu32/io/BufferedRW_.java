package com.yitu32.io;

import org.junit.Test;

import java.io.*;

/**
 * @ClassName BufferedRW_
 * @Author yitu32
 * @Description //TODO
 * @Date 2022/7/1
 * @Version 1.0
 */
public class BufferedRW_ {

    @Test
    public void test01() {
        BufferedReader bufferedReader = null;
        String content = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("e:\\test\\test03.txt"));
            while ((content = bufferedReader.readLine()) != null) {
                // 这里readLine会直接读取一行，然后返回String 很方便
                System.out.println(content);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 只需关闭最外层流
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test02() {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter("e:\\test\\test03.txt",true));
            String content = "hello 你好吗";
            bufferedWriter.write(content);
            // 写入换行符
            bufferedWriter.newLine();
            bufferedWriter.write(content,0,7);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 只需关闭最外层流
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
