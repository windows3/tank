package com.zsn.abstracfactory;

import com.zsn.tank.Tank;

import java.awt.*;

/**
 * @Author: zsn
 * @Date: 2020/5/11 23:10
 */
public abstract class BaseBullet  {
    public abstract void paint(Graphics g);

    public abstract void collideWith(BaseTank tank);
}
