package com.zsn.cor;

import com.zsn.tank.*;

/**
 * @Author: zsn
 * @Date: 2020/5/15 0:07
 */
public class BulletWallCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {

        if (o1 instanceof Bullet && o2 instanceof Wall) {
            Bullet b = (Bullet) o1;
            Wall w = (Wall) o2;
            if(b.rect.intersects(w.rect)){
                b.die();
            }


        } else if (o2 instanceof Bullet && o1 instanceof Wall) {
            return collide(o2, o1);
        }
        return true;

    }

}
