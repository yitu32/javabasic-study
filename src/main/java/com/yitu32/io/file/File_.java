package com.yitu32.io.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @ClassName File_
 * @Author yitu32
 * @Description //TODO
 * @Date 2022/7/1
 * @Version 1.0
 */
public class File_ {

    @Test
    public void test01() {
        // 三种构造方法，貌似一共有6种构造方法
        File file01 = new File("e:\\test\\test01.txt");
        File parent = new File("e:\\test\\");
        File file02 = new File(parent, "test02.txt");
        File file03 = new File("e:\\test\\", "test03.txt");
        // 如果不存在这个文件，file对象只是程序中的对象，没有和磁盘中的文件对应
        try {
            // exists() 不存在才创建
            if (!parent.exists()) {
                // mkdir() 创建文件夹      getName() 获取文件名称
                System.out.println(parent.mkdir() ? parent.getName() + "文件夹创建成功" : parent.getName() + "文件夹创建失败");
            }
            if (!file01.exists()) {
                // createNewFile() 创建文件 该文件所在的目录必须存在才行！
                System.out.println(file01.createNewFile() ? file01.getName() + "创建成功" : file01.getName() + "创建失败");
            }
            if (!file02.exists()) {
                System.out.println(file02.createNewFile() ? file02.getName() + "创建成功" : file02.getName() + "创建失败");
            }
            if (!file03.exists()) {
                System.out.println(file03.createNewFile() ? file03.getName() + "创建成功" : file03.getName() + "创建失败");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file02.getName() + "->文件的绝对路径是：" + file02.getAbsolutePath());
        System.out.println(file02.getName() + "->文件的父级目录是：" + file02.getParentFile());
        System.out.println(file02.getName() + "->文件的大小(字节)是：" + file02.length());
        System.out.println(file02.getName() + "->是目录吗：" + file02.isDirectory());
        System.out.println(file02.getName() + "->是文件吗：" + file02.isFile());
        // 以相对路径new一个文件，相对于当前项目
        File file05 = new File("test05.txt");
        if (!file05.exists()) {
            try {
                file05.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(file05.getName() + "->文件的绝对路径是：" + file05.getAbsolutePath());
        System.out.println(file05.getName() + "->文件的相对路径是：" + file05.getPath());


        File dirs01 = new File("e:\\test\\dirA01\\dirB01");
        File dirs02 = new File("e:\\test\\dirA01\\dirB02");
        if (!dirs01.exists()) {
            // mkdirs() 创建多级文件夹
            System.out.println(dirs01.mkdirs() ? dirs01.getAbsolutePath() + "文件夹创建成功" : dirs01.getAbsolutePath() + "文件夹创建失败");
        }
        if (!dirs02.exists()) {
            System.out.println(dirs02.mkdirs() ? dirs02.getAbsolutePath() + "文件夹创建成功" : dirs02.getAbsolutePath() + "文件夹创建失败");
        }

        File dirFile01 = new File(dirs01, "dirFile01.txt");
        if (!dirFile01.exists()) {
            try {
                boolean dirFile01Create = dirFile01.createNewFile();
                String sout = dirFile01Create ? "在目录" + dirs01 + "下新建文件" + dirFile01.getName() + "成功"
                        : "在目录" + dirs01 + "下新建文件" + dirFile01.getName() + "失败";
                System.out.println(sout);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        File dirFile02 = new File(dirs02, "dirFile02.txt");
        if (!dirFile02.exists()) {
            try {
                boolean dirFile02Create = dirFile02.createNewFile();
                String sout = dirFile02Create ? "在目录" + dirs02 + "下新建文件" + dirFile02.getName() + "成功"
                        : "在目录" + dirs02 + "下新建文件" + dirFile02.getName() + "失败";
                System.out.println(sout);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (dirFile01.delete()) {
            System.out.println("删除文件" + dirFile01 + "成功");
        } else {
            System.out.println("删除文件" + dirFile01 + "失败");
        }

        if (dirs01.delete()) {
            System.out.println("删除文件夹" + dirs01 + "成功");
        } else {
            System.out.println("删除文件夹" + dirs01 + "失败");
        }

        if (dirs02.delete()) {
            System.out.println("删除文件夹" + dirs02 + "成功");
        } else {
            System.out.println("删除文件夹" + dirs02 + "失败");
            System.out.println("遍历该文件夹" + dirs02);
            Arrays.stream(dirs02.listFiles()).forEach(s -> System.out.println(s));
        }
    }


}
