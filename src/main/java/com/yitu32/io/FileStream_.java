package com.yitu32.io;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @ClassName Stream
 * @Author yitu32
 * @Description //TODO
 * @Date 2022/7/1
 * @Version 1.0
 */
public class FileStream_ {
    /*
    流：java中的数据传输方式
    可分为：
        字节流，字符流
        输入流，输入流
        节点流，处理流
     */
    @Test
    public void test01() {
        String path = "e:\\test\\test01.txt";
        FileInputStream fileInputStream = null;
        int readData = 0;
        try {
            // 构造参数可以传文件类型
            // fileInputStream = new FileInputStream(new File(path));
            fileInputStream = new FileInputStream(path);
            // read() 一次读一个字节出来，交给int
            while ((readData = fileInputStream.read()) != -1) {
                System.out.println((char) readData);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test02() {
        String path = "e:\\test\\test02.txt";
        FileInputStream fileInputStream = null;
        byte[] readBuf = new byte[8192];
        int readLen = -1;
        try {
            fileInputStream = new FileInputStream(path);
            // 一次读最多 readBuf.length 个字节，具体读到多少字节，看readLen，返回-1表示读取完毕
            while ((readLen = fileInputStream.read(readBuf)) != -1) {
                System.out.println(new String(readBuf, 0, readLen, "GBK"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test03() {
        String path = "e:\\test\\test03.txt";
        FileOutputStream fileOutputStream = null;
        try {
            // 也可以传File
            // fileOutputStream = new FileOutputStream(new File(path));
            // 第二个参数表示是否追加内容，true表示追加，如果写，默认为false，表示每次都重新写入
            // fileOutputStream = new FileOutputStream(path, true);
            fileOutputStream = new FileOutputStream(path);
            // 写一个字节
            fileOutputStream.write('A');
            fileOutputStream.write('\n');
            // 写入字节数组
            fileOutputStream.write("hello world".getBytes());
            fileOutputStream.write("\n".getBytes());
            // 写入字节数组，指定起止位置
            fileOutputStream.write("hello world".getBytes(), 0, 5);
            fileOutputStream.write('\n');
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test04() {
        // 用字节流拷贝一个文件
        String src = "e:\\test\\20220101143216.png";
        String dest = "e:\\test\\20220101143216_copy.png";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        byte[] buf = new byte[8192];
        int readLen = -1;
        try {
            long begin = System.currentTimeMillis();
            fileInputStream = new FileInputStream(src);
            fileOutputStream = new FileOutputStream(dest);
            while ((readLen = fileInputStream.read(buf)) != -1) {
                fileOutputStream.write(buf, 0, readLen);
            }
            System.out.println("copy over,cost:" + (System.currentTimeMillis() - begin));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    @Test
    public void test05() {
        String path = "e:\\test\\test08.txt";
        FileOutputStream fileOutputStream = null;
        try {
            // 也可以传File
            // fileOutputStream = new FileOutputStream(new File(path));
            // 第二个参数表示是否追加内容，true表示追加，如果写，默认为false，表示每次都重新写入
            // fileOutputStream = new FileOutputStream(path, true);
            fileOutputStream = new FileOutputStream(path);
            // 写一个字节
            fileOutputStream.write('A');
            fileOutputStream.write('\n');
            // 写入字节数组
            fileOutputStream.write("hello world".getBytes());
            fileOutputStream.write("\n".getBytes());
            // 写入字节数组，指定起止位置
            fileOutputStream.write("hello world".getBytes(), 0, 5);
            fileOutputStream.write('\n');
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
