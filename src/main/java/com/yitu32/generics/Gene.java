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

    public void Method02(List<Integer> list) {
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
