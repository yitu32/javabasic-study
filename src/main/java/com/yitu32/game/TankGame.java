package com.yitu32.game;

import javax.swing.*;

// 画框
public class TankGame extends JFrame {
    MyPanel myPanel = null;

    public static void main(String[] args) {
        new TankGame();
    }

    public TankGame() {
        // 画板
        myPanel = new MyPanel();
        // 画板加入画框
        this.add(myPanel);
        // 单独为它启动一个线程来重画
        new Thread(myPanel).start();
        // 画框设置大小
        this.setSize(1000, 750);
        // 增加监听
        this.addKeyListener(myPanel);
        // 小叉退出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
