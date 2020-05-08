package com.zsn.tank;

import java.awt.*;

/**
 * @Author: zsn
 * @Date: 2020/5/6 0:46
 */
public class Bullet {
    private static final int SPEED = 10;
    private int x, y;
    public static final int WIDTH = ResourceMgr.bulletD.getWidth();
    public static final int HEIGHT = ResourceMgr.bulletD.getHeight();
    private TankFrame tf = null;
    private Dir dir;

    public boolean living = true;

    private Group group=Group.BAD;

    public Bullet(int x, int y, Dir dir,Group group, TankFrame tf) {

        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group=group;
        this.tf = tf;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void paint(Graphics g) {
        if (!living) {
            tf.bullets.remove(this);
        }
        switch (dir) {
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
        }

        move();

    }

    private void move() {
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;


    }

    /**
     * 碰撞
     *
     * @param tank
     */
    public void collideWith(Tank tank) {
        if(this.group==tank.getGroup()) return;

//        TODO 用一个rect来记录子弹的位置 ，让GC太忙了
        Rectangle rect1 = new Rectangle(this.x, this.y, WIDTH, HEIGHT);
        Rectangle rect2 = new Rectangle(tank.getX(), tank.getY(), tank.WIDTH, tank.HEIGHT);
        if (rect1.intersects(rect2)) {//是否相交
            tank.die();
            this.die();
            tf.explodes.add(new Explode(x,y,tf));
        }
    }

    private void die() {
        this.living =false;
    }
}
