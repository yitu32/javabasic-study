package com.yitu32.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class List_ {
    /*  List接口是Collection的子接口
        List中的元素**有序**且**可重复**
        每个元素都有其对应的索引位置，可以根据此索引取元素
        常见实现类：ArrayList LinkedList Vector
     */

    /**
     * 常用方法
     * void add(int index, Object ele):在index位置插入ele元素
     * boolean addAll(int index, Collection eles):从index位置开始将eles中
     * 的所有元素添加进来
     * Object get(int index):获取指定index位置的元素
     * int indexOf(Object obj):返回obj在集合中首次出现的位置
     * int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
     * Object remove(int index):移除指定index位置的元素，并返回此元素
     * Object set(int index, Object ele):设置指定index位置的元素为ele
     * List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex
     * 位置的子集合
     */
    @Test
    public void test01() {
        List<String> list01 = new ArrayList<>();
        list01.add("夏");
        list01.add("商");
        list01.add("周");
        list01.add("汉");
        // 可以在指定位置插入(index从0开始)
        list01.add(3, "秦");
        // 可以取指定位置的元素
        System.out.println(list01.get(4));
        List<String> list02 = new ArrayList<>();
        list02.add("汉");
        list02.add("三国");
        list02.add("晋");
        list02.add("五胡十六国");
        System.out.println("把list02放到list01中，从第二个索引开始插入");
        list01.addAll(2, list02);
        for (String s : list01) {
            System.out.println(s);
        }
        List<String> list03 = new ArrayList<>();
        list03.add("西游记");
        list03.add("红楼梦");
        list03.add("三国演义");
        list03.add("红楼梦");
        list03.add("水浒传");
        // 返回某个元素在集合中首次出现的位置
        int index01 = list03.indexOf("红楼梦");
        System.out.println("红楼梦首次出现的索引位置是:" + index01);
        // 返回某个元素在集合中最后一次出现的位置
        int index02 = list03.lastIndexOf("红楼梦");
        System.out.println("红楼梦最后出现的索引位置是:" + index02);
        String remove = list03.remove(1);
        System.out.println("移除索引位置为1的元素：" + remove);
        // 其它元素会往前补位
        for (int i = 0; i < list03.size(); i++) {
            String s = list03.get(i);
            System.out.println(s);
        }
        System.out.println("将索引位置为1的元素设置为\"金瓶梅\"");
        // 原索引位置将被替换
        list03.set(1, "金瓶梅");
        for (String s : list03) {
            System.out.println(s);
        }
        System.out.println("list03.subList(1, 3)");
        // subList方法，得到的集合，左闭右开
        List<String> subList = list03.subList(1, 3);
        for (String s : subList) {
            System.out.println(s);
        }
    }

    @Test
    public void test02() {
        /*List<String> list = new ArrayList<>();
        list.add("宋江");*/
    }

}
