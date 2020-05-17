package com.zsn.observer;

import com.zsn.tank.GameModel;
import com.zsn.tank.GameObject;
import com.zsn.tank.Tank;

/**
 * @Author: zsn
 * @Date: 2020/5/17 2:12
 */
public class GOEvent extends Event<GameObject> {

    GameObject gm;

    public GOEvent(GameObject gm) {
        super();
        this.gm = gm;
    }

    @Override
  public   GameObject getSource() {
        return gm;
    }
}
