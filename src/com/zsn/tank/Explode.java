package com.zsn.tank;

import java.awt.*;

/**
 * @Author: zsn
 * @Date: 2020/5/6 0:46
 */
public class Explode {
    private int x, y;
    public static final int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static final int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private int step = 0;

    TankFrame tf =null;


    public Explode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        new Thread(() -> new Audio("audio/explode.wav").play()).start();

    }


    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length)
            tf.explodes.remove(this);

    }

}
