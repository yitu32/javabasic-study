package com.yitu32.draw.move;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * KeyListener 键盘的事件监听
 */
public class MyMovePanel extends JPanel implements KeyListener {

    private int x = 10;
    private int y = 10;


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x, y, 20, 20);
    }

    /**
     * 有字符输出时
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * 某个键按下时
     *
     * @param e   KeyEvent 事件
     */
    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println((char) e.getKeyCode() + "键被按下...");
        //在 java 中，会给每一个键，分配一个值
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y++;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            y--;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x--;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            x++;
        }
        this.repaint();
    }

    /**
     * 某个键松开
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {

    }
}
