package com.zsn.tank;

import java.awt.*;

/**
 * @Author: zsn
 * @Date: 2020/5/6 0:46
 */
public class Explode  extends GameObject{

    public static final int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static final int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private int step = 0;




    public Explode(int x, int y) {
        this.x = x;
        this.y = y;

        new Thread(() -> new Audio("audio/explode.wav").play()).start();
        GameModel.getInstance().add(this);

    }


    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.explodes[step++], x, y, null);
        if (step >= ResourceMgr.explodes.length)
            GameModel.getInstance().remove(this);

    }

    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

}
