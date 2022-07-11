package com.yitu32.game.entity;

import com.yitu32.game.MyPanel;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName Bullet
 * @Author yitu32
 * @Description
 * @Date 2022/7
 * @Version 1.0
 */
public class Bullet extends Feature implements Runnable {

    public Bullet() {
        super();
    }

    // 通过tank对象可以得到当前子弹的初始位置，方向，类型
    public Bullet(Tank tank) {
        int[] bulletStart = tank.getBulletStart();
        this.setX(bulletStart[0]);
        this.setY(bulletStart[1]);
        this.setDirect(tank.getDirect());
        this.setType(tank.getType());
    }

    @Override
    public void run() {
        for (; ; ) {
            // 判断往哪边移动
            switch (getDirect()) {
                case up:
                    moveUp();
                    break;
                case down:
                    moveDown();
                    break;
                case left:
                    moveLeft();
                    break;
                case right:
                    moveRight();
                    break;
                default:
                    System.out.println("what are you doing?");
                    break;
            }
            // 范围之内
            if ((getX() > 0 && getX() < 1000) && (getY() > 0 && getY() < 750)) {
                // 重画
                // System.out.println("x=" + x + ",y=" + y);
                // 范围之外
            } else {
                setAlive(false);
                break;
            }
            try {
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
