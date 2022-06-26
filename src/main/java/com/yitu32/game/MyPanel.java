package com.yitu32.game;

import com.yitu32.game.entity.Enemy;
import com.yitu32.game.entity.Hero;
import com.yitu32.game.entity.Tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Vector;

public class MyPanel extends JPanel implements KeyListener {
    Hero hero = null;
    List<Enemy> enemies = new Vector();
    int enemySize = 3;

    public MyPanel() {
        // 初始化自己的坦克
        hero = new Hero(100, 100);
        // 向上
        hero.setDirect(Tank.Direct.up);
        // 初始化敌人的坦克
        for (int i = 0; i < enemySize; i++) {
            Enemy enemy = new Enemy(100 * (i + 1), 0);
            // 向下
            enemy.setDirect(Tank.Direct.down);
            enemies.add(enemy);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 填充矩形
        g.fillRect(0, 0, 1000, 750);
        // 画出坦克
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);

        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            drawTank(enemy.getX(), enemy.getY(), g, enemy.getDirect(), 0);
        }

    }

    /**
     * 画出坦克
     *
     * @param x      左上角x坐标
     * @param y      左上角y坐标
     * @param g      画笔
     * @param direct 坦克的方向
     * @param type   坦克类型
     */
    private void drawTank(int x, int y, Graphics g, Tank.Direct direct, int type) {
        switch (type) {
            // 我们的坦克
            case 0:
                g.setColor(Color.CYAN);
                break;
            // 敌人的坦克
            case 1:
                g.setColor(Color.YELLOW);
                break;
        }
        switch (direct) {
            case up:
                g.fill3DRect(x, y, 10, 60, false);
                g.fill3DRect(x + 30, y, 10, 60, false);
                g.fill3DRect(x + 10, y + 10, 20, 40, false);
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case right: //表示向右
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);//画出炮筒
                break;
            case down: //表示向下
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克盖子
                g.fillOval(x + 10, y + 20, 20, 20);//画出圆形盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//画出炮筒
                break;
            case left: //表示向左
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克盖子
                g.fillOval(x + 20, y + 10, 20, 20);//画出圆形盖子
                g.drawLine(x + 30, y + 20, x, y + 20);//画出炮筒
                break;
            default:
                System.out.println("nothing");
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char keyCode = (char) e.getKeyCode();
        if (keyCode == KeyEvent.VK_W) {
            hero.setDirect(Tank.Direct.up);
            hero.moveUp();
        } else if (keyCode == KeyEvent.VK_S) {
            hero.setDirect(Tank.Direct.down);
            hero.moveDown();
        } else if (keyCode == KeyEvent.VK_A) {
            hero.setDirect(Tank.Direct.left);
            hero.moveLeft();
        } else if (keyCode == KeyEvent.VK_D) {
            hero.setDirect(Tank.Direct.right);
            hero.moveRight();
        }

        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
