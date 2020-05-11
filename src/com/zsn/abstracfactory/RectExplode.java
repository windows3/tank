package com.zsn.abstracfactory;

import com.zsn.tank.Audio;
import com.zsn.tank.ResourceMgr;
import com.zsn.tank.TankFrame;

import java.awt.*;

/**
 * @Author: zsn
 * @Date: 2020/5/11 23:34
 */
public class RectExplode extends BaseExplode {
    private int x, y;
    public static final int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static final int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private int step = 0;

    TankFrame tf = null;


    public RectExplode(int x, int y, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.tf = tf;
        new Thread(() -> new Audio("audio/explode.wav").play()).start();

    }


    @Override
    public void paint(Graphics g) {

//        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        Color c = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x, y, 10 * step, 10 * step);
        step++;
        if (step >= 15)
            tf.explodes.remove(this);

        g.setColor(c);

    }

}
