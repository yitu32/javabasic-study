package com.yitu32.entity;

import java.util.Date;

// 部分保留
public class MiniDog<T,H> extends Dog<T, Date> {

    private H[] hobies;

    public H[] getHobies() {
        return hobies;
    }

    public void setHobies(H[] hobies) {
        // 这里不能是 new H[hobies.length] 只能是下面这种
        this.hobies = (H[]) new Object[hobies.length];
        this.hobies = hobies;
    }

    public MiniDog(){
        super();
    }

    public MiniDog(T faith, String name, Integer age) {
        super(faith, name, age);
    }

//    不能是静态方法
//    public static void sMethod01(T t){
//
//    }

    public void sMethod02(T t){

    }







}
