package com.zsn.cor;

import com.zsn.tank.Bullet;
import com.zsn.tank.GameObject;
import com.zsn.tank.Tank;

/**
 * @Author: zsn
 * @Date: 2020/5/15 0:07
 */
public class TankTankCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {

        if (o1 instanceof Tank && o2 instanceof Tank) {
            Tank t1 = (Tank) o1;
            Tank t2 = (Tank) o2;
            if (t1.getRect().intersects(t2.getRect())) {
                t1.stop();
//              t2.stop();

            }

        }
        return true;
    }


}
