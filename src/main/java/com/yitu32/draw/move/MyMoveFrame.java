package com.yitu32.draw.move;

import javax.swing.*;

/**
 * 让小球在窗口上移动
 */
public class MyMoveFrame extends JFrame {
    MyMovePanel panel = null;

    public static void main(String[] args) {
        new MyMoveFrame();
    }

    public MyMoveFrame() {
        panel = new MyMovePanel();
        this.setSize(500,400);
        this.add(panel);
        this.addKeyListener(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }


}
