package com.yitu32.game.entity;

import java.util.List;
import java.util.Vector;

public class Hero extends Tank {

    private List<Bullet> bullets;

    public Hero(int x, int y) {
        super(x, y);
    }

    public List<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(List<Bullet> bullets) {
        this.bullets = bullets;
    }

}
