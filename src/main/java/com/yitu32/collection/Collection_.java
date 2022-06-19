package com.yitu32.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Collection_ {
    /**
     * Collection 常用方法，暂以ArrayList作为实现类来阐述
     */
    @Test
    public void test01() {
        List<String> list01 = new ArrayList<>();
        // 集合中元素的个数
        System.out.println("list01.size()=" + list01.size());
        // 集合是否为空
        System.out.println("list01.isEmpty()=" + list01.isEmpty());
        // 增加元素
        System.out.println("往list01中增加5个元素");
        list01.add("夏");
        list01.add("商");
        list01.add("周");
        list01.add("汉");
        // 可以在指定位置插入
        list01.add(3, "秦");
        System.out.println("list01.size()=" + list01.size());
        System.out.println("list01.isEmpty()=" + list01.isEmpty());
        // 是否包含某个元素
        System.out.println("list01.contains(\"夏\")=" + list01.contains("夏"));
        System.out.println("list01.contains(\"唐\")=" + list01.contains("唐"));
        // 根据元素内容删除某个元素
        System.out.println("list01.remove(\"夏\")=" + list01.remove("夏"));
        System.out.println("list01.contains(\"夏\")=" + list01.contains("夏"));
        System.out.println("list01.size()=" + list01.size());
        // 清空list01
        System.out.println("===清空list01===");
        list01.clear();
        System.out.println("list01.size()=" + list01.size());
        System.out.println("list01.isEmpty()=" + list01.isEmpty());
    }

    /**
     * 遍历
     */
    @Test
    public void test02() {
        List<String> list01 = new ArrayList<>();
        list01.add("夏");
        list01.add("商");
        list01.add("周");
        list01.add("秦");
        list01.add("汉");
        // 普通for循环
        for (int i = 0; i < list01.size(); i++) {
            // 得到某一个索引位置的元素(List中的方法)
            String s = list01.get(i);
            System.out.println(s);
        }
        // 迭代器,用于遍历Collection
        // 得到一个迭代器
        Iterator<String> iterator = list01.iterator();
        // 判断是否有下一个元素
        while (iterator.hasNext()) {
            // 如果有下一个元素，才可以调用next()方法
            String next = iterator.next();
            System.out.println(next);
            // 可以根据条件删除元素，注意此时调用的是迭代器的remove()方法
            // iterator.remove();
        }
        // 增强for循环又叫foreach循环，底层调用的是Iterator，可以用来遍历集合或者数组
        for (String s : list01) {
            System.out.println(s);
        }
        // 集合可以转数组，数组可以用foreach遍历
        System.out.println("===集合可以转数组===");
        Object[] objects = list01.toArray();
        for (Object object : objects) {
            System.out.println(object);
        }
    }

    /**
     * 两个集合之间的关系
     */
    @Test
    public void test03() {
        List<String> list01 = new ArrayList<>();
        list01.add("夏");
        list01.add("商");
        list01.add("周");
        list01.add("秦");
        list01.add("汉");
        for (String s : list01) {
            System.out.println(s);
        }
        List<String> list02 = new ArrayList<>();
        list02.add("汉");
        list02.add("三国");
        list02.add("晋");
        list02.add("五胡十六国");
        List<String> list03 = new ArrayList<>();
        list03.add("商");
        list03.add("汉");
        // 把list02全部添加到list01中，包含重复的
        list01.addAll(list02);
        System.out.println("list01.addAll(list02)之后");
        for (String s : list01) {
            System.out.println(s);
        }
        System.out.println("list01.containsAll(list03)=" + list01.containsAll(list03));
        // list01作为基准，没有在list03中的，都移除，最后取的是两个集合都包含的，
        // 如果list01中重复元素刚好符合这个规律，则都会保留
        list01.retainAll(list03);
        System.out.println("list01.retainAll(list03)之后");
        for (String s : list01) {
            System.out.println(s);
        }
        // 从list01中删除同时存在于list01和list03中的元素，如果有重复的会多次删除
        list01.removeAll(list03);
        System.out.println("list01.removeAll(list03)之后");
        for (String s : list01) {
            System.out.println(s);
        }
        // 可以判断两集合是否相等，比较的是两个集合中的元素是否相等
        System.out.println("list01.equals(list02)=" + list01.equals(list02));
    }

}
