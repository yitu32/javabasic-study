package com.yitu32.game;

import javax.swing.*;

public class TankGame extends JFrame {
    MyPanel myPanel = null;

    public static void main(String[] args) {
        new TankGame();
    }

    public TankGame() {
        myPanel = new MyPanel();
        this.add(myPanel);
        this.setSize(1000, 750);
        this.addKeyListener(myPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
