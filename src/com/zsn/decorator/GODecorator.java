package com.zsn.decorator;

import com.zsn.tank.GameObject;

import java.awt.*;

/**
 * @Author: zsn
 * @Date: 2020/5/16 22:07
 */
public abstract class GODecorator extends GameObject {

    GameObject go;

    public GODecorator(GameObject go) {
        this.go = go;
    }

    @Override
    public  abstract void paint(Graphics g);

}
