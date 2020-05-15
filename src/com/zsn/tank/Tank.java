package com.zsn.tank;

import com.zsn.strategy.DefaultFireStrategy;
import com.zsn.strategy.FireStrategy;

import java.awt.*;
import java.util.Random;

/**
 * @Author: zsn
 * @Date: 2020/5/6 0:06
 */
public class Tank extends GameObject {

    public int x, y;
    public int oldX, oldY;
    private boolean moving = true;

    public static final int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static final int HEIGHT = ResourceMgr.goodTankU.getHeight();
    public Dir dir = Dir.DOWN;
    private static final int SPEED = 5;
    private boolean living = true;
    private Random random = new Random();
    public Group group = Group.BAD;
    public Rectangle rect = new Rectangle();

    private FireStrategy DF;
    public GameModel gm;

    public Tank(int x, int y, Dir dir, Group group, GameModel gm) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gm = gm;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
        if (this.group == Group.GOOD) {
            String goodFSName = (String) PropertyMgr.get("goodFs");
            try {
                DF = (FireStrategy) Class.forName(goodFSName).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (this.group == Group.BAD) {
            DF = new DefaultFireStrategy();
        }
    }

    @Override
    public void paint(Graphics g) {
        if (!living) gm.remove(this);

        //加载图片
        switch (dir) {
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
                break;
        }


        move();

    }
public void back(){
        x=oldX;
        y=oldY;
}

    public void move() {
        oldX=x;
        oldY=y;
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


        if (this.group == Group.BAD && random.nextInt(100) > 95)
            this.fire();

        if (this.group == Group.BAD && random.nextInt(100) > 95)
            randomDir();

//            边界检测
        boundsCheck();
//        update rect
        rect.x = this.x;
        rect.y = this.y;

    }

    private void boundsCheck() {
        if (this.x < 2) x = 2;
        if (this.y < 28) y = 28;
        if (this.x > TankFrame.GAME_WIDTH - Tank.WIDTH - 2) x = TankFrame.GAME_WIDTH - Tank.WIDTH - 2;
        if (this.y > TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2) y = TankFrame.GAME_HEIGHT - Tank.HEIGHT - 2;
    }

    private void randomDir() {


        this.dir = Dir.values()[random.nextInt(4)];
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void fire() {
        DF.fire(this);
    }

    public void die() {
        this.living = false;
    }


    public Rectangle getRect() {
        return rect;
    }

    public void stop() {
        this.moving = false;
        this.oldX = x;
        this.oldY = y;

//        if (!moving) {
//            if (this.group == Group.BAD) {
//                if (random.nextInt(100) > 95) {
//
//                    this.x = oldX - 1;
//                    this.y = oldY + 1;
//                } else {
//                    this.x = oldX;
//                    this.y = oldY;
//                }
//                this.moving = true;
//                move();
//            } else {
//                return;
//            }
//
//        }
    }
}
