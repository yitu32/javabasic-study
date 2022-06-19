package com.yitu32.generics;

/*
这样是不行的这里是要一个泛型实参
public class Basic01 <? extends String>{
}*/

public class Basic01<T extends String> {
    private T name;

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public <E> E test01(T t, E e) {

        return e;
    }
}
