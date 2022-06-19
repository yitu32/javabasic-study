package com.yitu32.entity;

// 部分保留，并且扩展自己的泛型
public class Dog<T, B> extends Animal<T, String, Integer> {

    private B birthDay;

    public Dog(T faith, String name, Integer age) {
        super(faith, name, age);
    }

    public Dog() {
        super();
    }

    public B getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(B birthDay) {
        this.birthDay = birthDay;
    }
}
