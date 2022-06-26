package com.yitu32.draw.paint;

import javax.swing.*;

// JFrame -> 画框
public class DrawCircle extends JFrame {

    private MyPanel myPanel;

    public static void main(String[] args) {
        new DrawCircle();
        System.out.println("退出程序~");
    }

    public DrawCircle() {
        myPanel = new MyPanel(); //画板
        this.add(myPanel);//画板加入到画框
        this.setSize(400,300);
        // 点击小X,程序退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 可以显示
        this.setVisible(true);
    }
}
