package com.yitu32.game.entity;

import com.yitu32.game.enums.Direct;
import com.yitu32.game.enums.TankType;

/**
 * @ClassName Feature
 * @Author yitu32
 * @Description //TODO
 * @Date 2022/7/7 16:40
 * @Version 1.0
 */
public class Feature {

    public Feature() {
    }

    public Feature(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 横坐标
     */
    private int x;
    /**
     * 纵坐标
     */
    private int y;
    /**
     * 方向
     */
    private Direct direct;
    /**
     * 类型
     */
    private TankType type;
    /**
     * 速度
     */
    public int speed = 1;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direct getDirect() {
        return direct;
    }

    public void setDirect(Direct direct) {
        this.direct = direct;
    }

    public TankType getType() {
        return type;
    }

    public void setType(TankType type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void moveUp() {
        y -= speed;
    }

    public void moveDown() {
        y += speed;
    }

    public void moveLeft() {
        x -= speed;
    }

    public void moveRight() {
        x += speed;
    }
}
