package com.yitu32.game.entity;

import com.yitu32.game.enums.Direct;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Enemy extends Tank implements Runnable {

    public Enemy(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        while (true) {
            // 在某个范围随机移动
            Random random = new Random();
            int times = random.nextInt(100);
            int direct = random.nextInt(4);

            try {
                move(direct, times);
                // 发射子弹
                TimeUnit.MILLISECONDS.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.shoot();
        }
    }

    private void move(int direct, int times) throws InterruptedException {
        switch (direct) {
            case 0:
                this.setDirect(Direct.up);
                for (int i = 0; i < times; i++) {
                    moveUp();
                    if (this.getY() <= 0) {
                        break;
                    }
                    TimeUnit.MILLISECONDS.sleep(50);
                }
                break;
            case 1:
                this.setDirect(Direct.down);
                for (int i = 0; i < times; i++) {
                    moveDown();
                    if (this.getY() + 60 >= 750) {
                        break;
                    }
                    TimeUnit.MILLISECONDS.sleep(50);
                }
                break;
            case 2:
                this.setDirect(Direct.left);
                for (int i = 0; i < times; i++) {
                    moveLeft();
                    if (this.getX() <= 0) {
                        break;
                    }
                    TimeUnit.MILLISECONDS.sleep(50);
                }
                break;
            case 3:
                this.setDirect(Direct.right);
                for (int i = 0; i < times; i++) {
                    moveRight();
                    if (this.getX() + 60 >= 1000) {
                        break;
                    }
                    TimeUnit.MILLISECONDS.sleep(50);
                }
                break;
            default:
                break;
        }

    }
}
