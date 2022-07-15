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
    List<Bomb> bombs = new Vector<>();

    Image image1, image2, image3;

    public MyPanel() {
        // 构造方法中初始化坦克（此时并未画出来）
        // 1.初始化自己的坦克
        hero = new Hero(100, 100, Direct.up, TankType.good);
        // 2.初始化敌人的坦克
        for (int i = 0; i < enemySize; i++) {
            Enemy enemy = new Enemy(100 * (i + 1), 0, Direct.down, TankType.bad);
            enemies.add(enemy);
            Feature.tankThread.execute(enemy);
        }
        // 初始化几张爆炸图片
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_3.gif"));

    }

    // 重画也会调用到这个方法，所以，这个方法里面就是==此时此刻==要画的所有东西
    // 包括此刻的所有坦克和此刻的所有子弹
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // 填充矩形
        g.fillRect(0, 0, 1000, 750);
        // 画出内存中我们的坦克
        drawTank(hero.getX(), hero.getY(), g, hero);
        // 有子弹对象就要画出子弹对象
        drawBullets(hero, g);
        // 画出内存中敌人的坦克
        for (int i = 0; i < enemies.size(); i++) {
            Enemy enemy = enemies.get(i);
            drawTank(enemy.getX(), enemy.getY(), g, enemy);
            drawBullets(enemy, g);
        }
        // 如果有炸弹，就要画出来
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.getLife() > 6) {
                g.drawImage(image1, bomb.getX(), bomb.getY(), 60, 60, this);
            } else if (bomb.getLife() > 3) {
                g.drawImage(image2, bomb.getX(), bomb.getY(), 60, 60, this);
            } else if (bomb.getLife() > 0) {
                g.drawImage(image3, bomb.getX(), bomb.getY(), 60, 60, this);
            }
            bomb.lifeDown();
            if (!bomb.isAlive()) {
                bombs.remove(bomb);
            }
        }
    }

    /**
     * 画出坦克
     *
     * @param x 左上角x坐标
     * @param y 左上角y坐标
     * @param g 画笔
     */
    private void drawTank(int x, int y, Graphics g, Tank tank) {
        // 存活才画出来
        if (!tank.isAlive()) {
            return;
        }
        Direct direct = tank.getDirect();
        TankType type = tank.getType();
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

    /**
     * 画出某一个坦克对应的所有子弹
     * @param t
     * @param g
     */
    private void drawBullets(Tank t, Graphics g) {
        List<Bullet> bullets = t.getBullets();
        if (bullets != null && bullets.size() > 0) {
            for (int i = 0; i < bullets.size(); i++) {
                Bullet bullet = bullets.get(i);
                // 子弹存活才画
                if (bullet != null && bullet.isAlive()) {
                    if (TankType.good == t.getType()) {
                        g.setColor(Color.RED);
                    } else if (TankType.bad == t.getType()) {
                        g.setColor(Color.GREEN);
                    }
                    g.draw3DRect(bullet.getX(), bullet.getY(), 1, 1, false);
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * 键盘按压事件
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        char keyCode = (char) e.getKeyCode();
        if (keyCode == KeyEvent.VK_W || keyCode == KeyEvent.VK_UP) {
            hero.setDirect(Direct.up);
            hero.moveUp();
        } else if (keyCode == KeyEvent.VK_S || keyCode == KeyEvent.VK_DOWN) {
            hero.setDirect(Direct.down);
            hero.moveDown();
        } else if (keyCode == KeyEvent.VK_A || keyCode == KeyEvent.VK_LEFT) {
            hero.setDirect(Direct.left);
            hero.moveLeft();
        } else if (keyCode == KeyEvent.VK_D || keyCode == KeyEvent.VK_RIGHT) {
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
            // 判断子弹是否打到坦克内部
            hit();
            this.repaint();
        }
    }

    /**
     * 判断是否有子弹打到内部
     */
    private void hit() {
        Hero hero = this.getHero();
        if (hero != null) {
            // 判断每颗子弹是否在范围内
            List<Bullet> bullets = hero.getBullets();
            if (bullets == null || bullets.size() == 0) {
                return;
            }
            for (Bullet bullet : bullets) {
                if (bullet != null && bullet.isAlive()) {
                    List<Enemy> enemies = this.getEnemies();
                    for (Enemy enemy : enemies) {
                        doHit(bullet, enemy);
                    }
                }
            }
        }
    }

    // 判断某一个子弹是否击中某一个坦克
    private void doHit(Bullet bullet, Tank tank) {
        if (!tank.isAlive()) return;
        Direct direct = tank.getDirect();
        switch (direct) {
            case up:
            case down:
                if (bullet.getX() > tank.getX() && bullet.getX() < tank.getX() + 40
                        && bullet.getY() > tank.getY() && bullet.getY() < tank.getY() + 60) {
                    tank.setAlive(false);
                    bullet.setAlive(false);
                    // 击中之后创造一个爆炸对象
                    bombs.add(new Bomb(tank.getX(),tank.getY()));
                }
                break;
            case left:
            case right:
                if (bullet.getX() > tank.getX() && bullet.getX() < tank.getX() + 60
                        && bullet.getY() > tank.getY() && bullet.getY() < tank.getY() + 40) {
                    tank.setAlive(false);
                    bullet.setAlive(false);
                    // 击中之后创造一个爆炸对象
                    bombs.add(new Bomb(tank.getX(),tank.getY()));
                }
                break;
            default:
                break;
        }
    }


    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<Enemy> enemies) {
        this.enemies = enemies;
    }

    public int getEnemySize() {
        return enemySize;
    }

    public void setEnemySize(int enemySize) {
        this.enemySize = enemySize;
    }
}
