package com.yitu32.game;

import com.yitu32.game.entity.*;
import com.yitu32.game.enums.Direct;
import com.yitu32.game.enums.TankType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

/**
 * 画板实现了监听器
 */
public class MyPanel extends JPanel implements KeyListener, Runnable {
    // 我们的坦克
    Hero hero = null;
    // 敌人的坦克
    List<Enemy> enemies = new Vector();
    int enemySize = 3;

    public MyPanel() {
        // 初始化自己的坦克
        hero = new Hero(100, 100);
        // 向上
        hero.setDirect(Direct.up);
        hero.setType(TankType.good);
        // 初始化敌人的坦克
        for (int i = 0; i < enemySize; i++) {
            Enemy enemy = new Enemy(100 * (i + 1), 0);
            // 向下
            enemy.setDirect(Direct.down);
            enemy.setType(TankType.bad);
            enemies.add(enemy);
            Feature.tankThread.execute(enemy);
        }
    }

    // 重画也会调用到这个方法，所以，这个方法里面就是当前要画的所有东西
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 填充矩形
        g.fillRect(0, 0, 1000, 750);
        // 画出我们的坦克
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), hero.getType());
        // 画出别人的坦克
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            drawTank(enemy.getX(), enemy.getY(), g, enemy.getDirect(), enemy.getType());
            drawBullets(enemy, g);
        }
        // 有子弹对象就要画出子弹对象
        drawBullets(hero, g);
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
    private void drawTank(int x, int y, Graphics g, Direct direct, TankType type) {
        switch (type) {
            // 我们的坦克
            case good:
                g.setColor(Color.CYAN);
                break;
            // 敌人的坦克
            case bad:
                g.setColor(Color.YELLOW);
                break;
        }
        // 上下左右有不同画法
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


    private void drawBullets(Tank t, Graphics g) {
        List<Bullet> bullets = t.getBullets();
        if (bullets != null && bullets.size() > 0) {
            for (int i = 0; i < bullets.size(); i++) {
                Bullet bullet = bullets.get(i);
                if (bullet != null && bullet.isAlive()) {
                    drawBullet(bullet.getX(), bullet.getY(), g, bullet.getDirect());
                }
            }
        }
    }

    // 画出子弹
    private void drawBullet(int x, int y, Graphics g, Direct direct) {
        g.setColor(Color.RED);
        g.draw3DRect(x, y, 1, 1, false);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        char keyCode = (char) e.getKeyCode();
        if (keyCode == KeyEvent.VK_W) {
            hero.setDirect(Direct.up);
            hero.moveUp();
        } else if (keyCode == KeyEvent.VK_S) {
            hero.setDirect(Direct.down);
            hero.moveDown();
        } else if (keyCode == KeyEvent.VK_A) {
            hero.setDirect(Direct.left);
            hero.moveLeft();
        } else if (keyCode == KeyEvent.VK_D) {
            hero.setDirect(Direct.right);
            hero.moveRight();
        }

        // 发弹
        if (keyCode == KeyEvent.VK_J) {
            hero.shoot();
        }

        this.repaint();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * 单独启一个线程来不停重画
     */
    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }
}
