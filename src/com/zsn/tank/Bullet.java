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
    Rectangle rect =new Rectangle();

    public boolean living = true;

    private Group group=Group.BAD;

    public Bullet(int x, int y, Dir dir,Group group, TankFrame tf) {

        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group=group;
        this.tf = tf;

        rect.x =this.x;
        rect.y =this.y;
        rect.width =WIDTH;
        rect.height =HEIGHT;

        tf.bullets.add(this);
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

        rect.x=this.x;
        rect.y=this.y;
    }

    /**
     * 碰撞
     *
     * @param tank
     */
    public void collideWith(Tank tank) {
        if(this.group==tank.getGroup()) return;


        if (rect.intersects(tank.rect)) {//是否相交
            tank.die();
            this.die();
            int eX = tank.x + Tank.WIDTH / 2 - Explode.WIDTH / 2;
            int eY = tank.y + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
            tf.explodes.add(new Explode(eX,eY,tf));
        }
    }

    private void die() {
        this.living =false;
    }
}
