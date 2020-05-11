package com.zsn.abstracfactory;

import com.zsn.tank.Group;

import java.awt.*;

/**
 * @Author: zsn
 * @Date: 2020/5/11 23:13
 */
public abstract class BaseTank {
    public abstract void paint(Graphics g);

    public Group group = Group.BAD;
    public Rectangle rect = new Rectangle();
    public  Group getGroup(){
        return group;
    }

    public abstract void die();

    public abstract int getX();

    public abstract int getY();
}
