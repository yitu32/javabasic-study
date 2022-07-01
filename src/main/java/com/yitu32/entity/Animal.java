package com.yitu32.entity;

import java.io.Serializable;

public class Animal<T, K, V> implements Serializable {

    private static final long serialVersionUID = 775365956450828333L;

    private T faith;
    private K name;
    private V age;

    public Animal() {

    }

    public Animal(T faith, K name, V age) {
        this.faith = faith;
        this.name = name;
        this.age = age;
    }

    public T getFaith() {
        return faith;
    }

    public void setFaith(T faith) {
        this.faith = faith;
    }

    public K getName() {
        return name;
    }

    public void setName(K name) {
        this.name = name;
    }

    public V getAge() {
        return age;
    }

    public void setAge(V age) {
        this.age = age;
    }
}
