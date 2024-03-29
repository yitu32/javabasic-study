package com.yitu32.game.entity;

import com.yitu32.game.MyPanel;
import com.yitu32.game.enums.Direct;
import com.yitu32.game.enums.TankType;

import java.util.List;
import java.util.Vector;

public class Tank extends Feature {


    private List<Bullet> bullets;

    public List<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(List<Bullet> bullets) {
        this.bullets = bullets;
    }

    public Tank() {
    }

    public Tank(int x, int y) {
        this.setX(x);
        this.setY(y);
    }

    public Tank(int x, int y, Direct direct, TankType type) {
        super(x, y, direct, type);
    }

    /**
     * 得到当前坦克对象的炮筒位置，即子弹发射初始位置
     *
     * @return
     */
    public int[] getBulletStart() {
        int[] ints = new int[2];
        int x, y;
        switch (getDirect()) {
            case up:
                x = this.getX() + 20;
                y = this.getY();
                break;
            case down:
                x = this.getX() + 20;
                y = this.getY() + 60;
                break;
            case left:
                x = this.getX();
                y = this.getY() + 20;
                break;
            case right:
                x = this.getX() + 60;
                y = this.getY() + 20;
                break;
            default:
                System.out.println("what are you doing?");
                x = 0;
                y = 0;
                break;
        }
        ints[0] = x;
        ints[1] = y;
        return ints;
    }

    /**
     * 发射子弹
     */
    public void shoot() {
        Bullet bullet = new Bullet(this);
        TankType type = this.getType();
        // 分为敌方和我方
        if (TankType.bad == type) {
            MyPanel.enemyBullets.add(bullet);
        } else {
            List<Bullet> bullets = this.getBullets();
            if (bullets == null) {
                bullets = new Vector<>();
                this.setBullets(bullets);
            }
            bullets.add(bullet);
        }
        // 放入一个线程中
        Feature.bulletsThread.execute(bullet);
    }

}
