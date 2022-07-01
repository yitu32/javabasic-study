package com.yitu32.io;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @ClassName ReaderWriter_
 * @Author yitu32
 * @Description //TODO
 * @Date 2022/7/1
 * @Version 1.0
 */
public class ReaderWriter_ {

    @Test
    public void test01() {
        String path = "E:\\test\\test03.txt";
        FileReader reader = null;
        int read = 0;
        try {
            reader = new FileReader(path);
            // 读一个字符
            while ((read = reader.read()) != -1) {
                System.out.println((char) read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test02() {
        String path = "E:\\test\\test03.txt";
        FileReader reader = null;
        char[] buf = new char[8192];
        int readLen = 0;
        try {
            reader = new FileReader(path);
            // 一次读取 buf.length个字符，readLen 为实际读取到的字符数，读取完毕返回 -1
            while ((readLen = reader.read(buf)) != -1) {
                System.out.println(new String(buf, 0, readLen));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test03() {
        String path = "E:\\test\\test03.txt";
        FileWriter writer = null;
        try {
            writer = new FileWriter(path,true);
            // 写一个字符 char -> int
            writer.write('M');
            writer.write('\n');
            String str = "关关雎鸠，在河之洲，窈窕淑女，君子好逑";
            // 写一个字符数组
            writer.write(str.toCharArray());
            writer.write('\n');
            // 可以直接写字符串
            writer.write(str);
            writer.write('\n');
            // 字符数组指定起止位置
            writer.write(str.toCharArray(),0,3);
            writer.write('\n');
            // 字符串指定起止位置
            writer.write(str,0,5);
            writer.write('\n');
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
