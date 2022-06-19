package com.yitu32.generics;

import com.yitu32.entity.MiniDog;

import java.util.ArrayList;
import java.util.List;

public class DoTest {
    public static void main(String[] args) {
        Gene<Object, Object, Object> obj = new Gene<>();
        obj.setK("aaa");
        obj.setV("bbb");
        String abc = obj.genercMethod("abc");
        System.out.println(abc.getClass());

        List<Number> list01 = new ArrayList<>();
        List<Integer> list02 = new ArrayList<>();

        MiniDog<String,String> miniDog = new MiniDog<>();

    }

    public void test02() {
        List<Number> list01 = new ArrayList<>();
        List<Integer> list02 = new ArrayList<>();
        Gene gene = new Gene();
        gene.Method02(list01);
        gene.Method02(list02);

    }

    public static void Method3(List list) {


    }


}
