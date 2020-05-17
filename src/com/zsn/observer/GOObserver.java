package com.zsn.observer;

import com.zsn.tank.GameObject;
import com.zsn.tank.Tank;

/**
 * @Author: zsn
 * @Date: 2020/5/17 2:20
 */
public class GOObserver implements Observer<Event> {

    GameObject go;

    public GOObserver(GameObject go) {
        this.go = go;
    }

    @Override
    public void actionOnFire(Event e) {
        if (e.getSource() instanceof Tank) {
            Tank t = (Tank) go;
            t.fire();
            System.out.println("fire");
        }
    }

}
