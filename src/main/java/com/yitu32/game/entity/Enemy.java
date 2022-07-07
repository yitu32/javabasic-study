package com.yitu32.game.entity;

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
            move(direct, times);
            // 发射子弹
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.shoot();
        }
    }

    private void move(int direct, int times) {
        switch (direct) {
            case 0:
                for (int i = 0; i < times; i++) {
                    moveUp();
                }
                break;
            case 1:
                for (int i = 0; i < times; i++) {
                    moveDown();
                }
                break;
            case 2:
                for (int i = 0; i < times; i++) {
                    moveLeft();
                }
                break;
            case 3:
                for (int i = 0; i < times; i++) {
                    moveRight();
                }
                break;
            default:
                break;
        }

    }
}
