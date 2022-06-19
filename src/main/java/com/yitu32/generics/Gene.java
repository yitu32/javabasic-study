package com.yitu32.generics;

import java.util.List;

public class Gene<K, V, M> {
    private K k;
    private V v;

    public K getK() {
        return k;
    }

    public void setK(K k) {
        this.k = k;
    }

    public V getV() {
        return v;
    }

    public void setV(V v) {
        this.v = v;
    }


    public <T> T genercMethod(T t) {
        System.out.println(t.getClass());
        System.out.println(t);
        return t;
    }

    public void MethodInteger(List<Integer> list) {
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    public void MethodNumber(List<Number> list) {
        for (Number i : list) {
            System.out.println(i);
        }
    }

    public void MethodObject(List<Object> list) {
        for (Object i : list) {
            System.out.println(i);
        }
    }

    public void MethodWildcard(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    public void MethodWildcardExtends(List<? extends Number> list) {
        for (Number number : list) {
            System.out.println(number);
        }
    }

}
