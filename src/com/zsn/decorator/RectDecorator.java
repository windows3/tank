package com.zsn.decorator;

import com.zsn.tank.GameObject;

import java.awt.*;

/**
 * @Author: zsn
 * @Date: 2020/5/16 22:08
 */
public class RectDecorator extends GODecorator {

    public RectDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x=go.x;
        this.y=go.y;
        go.paint(g);

        Color c = g.getColor();
        g.setColor(Color.WHITE);
        g.drawRect(go.x, go.y, go.getWidth()+2, go.getHeight()+2);
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return super.go.getWidth();
    }

    @Override
    public int getHeight() {
        return super.go.getHeight();
    }
}
