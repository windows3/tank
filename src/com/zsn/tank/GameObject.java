package com.zsn.tank;

import java.awt.*;

/**
 * @Author: zsn
 * @Date: 2020/5/14 23:44
 */
//游戏物体
public abstract class GameObject {
   public int x, y;

    public abstract void paint(Graphics g);

    public abstract int getWidth();

    public abstract int getHeight();

}
