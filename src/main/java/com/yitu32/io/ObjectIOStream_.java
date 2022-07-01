package com.yitu32.io;

import com.yitu32.entity.Dog;
import org.junit.Test;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName ObjectIOStream_
 * @Author yitu32
 * @Description //TODO
 * @Date 2022/7/1
 * @Version 1.0
 */
public class ObjectIOStream_ {
    /*
    序列化：
    保存的是数据的值和类型
    之前也不是很理解，比如我们要保存一个狗的对象，把它的属性和方法保存到文本文件中不久行了吗？
    但是读出来的也是文本，不是那个狗的对象，我们可能要进行一系列操作才能转换成我们要的那个对象
    而ObjectInputStream 读出来就是一个对象，就很nice
     */
    @Test
    public void test01() throws ParseException {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("e:\\test\\testOOS"));
            oos.writeInt(123);
            oos.writeBoolean(true);
            oos.writeChar('中');
            oos.writeUTF("你好");
            Dog<String, Date> dog = new Dog<>();
            dog.setAge(2);
            dog.setName("小花");
            dog.setFaith("myself");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = sdf.parse("2020-01-01 00:00:00");
            dog.setBirthDay(date);
            // 写对象时，这个对象得实现序列化接口，并且对象的属性也要实现序列化接口
            // 序列化具备可继承性
            oos.writeObject(dog);
            // 它保存的东西不是一个文本文件，有它自己的格式，我们是看不懂的
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void test02() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("e:\\test\\testOOS"));
            // 这里读的顺序要和写的顺序一致，否则报错
            System.out.println(ois.readInt());
            System.out.println(ois.readBoolean());
            System.out.println(ois.readChar());
            System.out.println(ois.readUTF());
            Dog dog = (Dog) ois.readObject();
            System.out.println(dog);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
