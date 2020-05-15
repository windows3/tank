package com.zsn.cor;

import com.zsn.tank.GameObject;
import com.zsn.tank.Tank;
import com.zsn.tank.Wall;

/**
 * @Author: zsn
 * @Date: 2020/5/15 0:07
 */
public class TankWallCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {

        if (o1 instanceof Tank && o2 instanceof Wall) {
            Tank t = (Tank) o1;
            Wall w = (Wall) o2;
            if (t.getRect().intersects(w.rect)) {
                t.back();
//                t2.back();

            }

        }else if(o1 instanceof Wall && o2 instanceof Tank ){
            collide(o2,o1);
        }
        return true;
    }


}
