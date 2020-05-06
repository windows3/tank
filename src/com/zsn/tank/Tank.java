package com.zsn.tank;

import java.awt.*;

/**
 * @Author: zsn
 * @Date: 2020/5/6 0:06
 */
public class Tank {

    private int x;
    private int y;
    private boolean moving = false;
    private TankFrame tankFrame;

    private Dir dir = Dir.DOWN;
    private static final int SPEED = 10;

    public Tank(int x, int y, Dir dir,TankFrame tankFrame) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame=tankFrame;
    }

    public void paint(Graphics g) {
        //加载图片
        switch (dir){
            case LEFT:
                g.drawImage(ResourceMgr.tankL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR,x,y,null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU,x,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD,x,y,null);
                break;
        }


        move();

    }

    private void move() {
        if (!moving) return;
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
    }

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

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void fire() {
        tankFrame.bullets.add(new Bullet(this.x, this.y, this.dir,this.tankFrame));
    }
}
