package com.yitu32.game.entity;

import com.yitu32.game.enums.Direct;
import com.yitu32.game.enums.TankType;

import java.util.List;
import java.util.Vector;

public class Hero extends Tank {

    private List<Bullet> bullets;

    public Hero(int x, int y) {
        super(x, y);
    }

    public Hero(int x, int y, Direct direct, TankType type) {
        super(x,y,direct,type);
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(List<Bullet> bullets) {
        this.bullets = bullets;
    }

}
