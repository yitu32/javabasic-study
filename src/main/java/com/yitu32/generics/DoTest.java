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
        // 没搞懂为什么这样就可以
        Gene gene = new Gene();
        gene.MethodInteger(list01);
        gene.MethodInteger(list02);
        gene.MethodNumber(list01);
        gene.MethodNumber(list02);

        Gene<String, String, Integer> ssi = new Gene<>();
        // 编译报错
        // ssi.MethodInteger(list01);
        ssi.MethodNumber(list01);
        ssi.MethodInteger(list02);
        // 编译报错
        // ssi.MethodNumber(list02);
        // 编译报错 不存在子父类关系
        // ssi.MethodObject(list01);
        // 编译报错 不存在子父类关系
        // ssi.MethodObject(list02);
        // List<?> 通配  相当于是所有 List<T> 的父类
        ssi.MethodWildcard(list01);
        ssi.MethodWildcard(list02);

        // List<? extends Number> 有上限的通配
        ssi.MethodWildcardExtends(list01);
        ssi.MethodWildcardExtends(list02);

    }

    public void test03(){


    }



}
