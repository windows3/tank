package com.zsn.cor;

import com.zsn.tank.*;

/**
 * @Author: zsn
 * @Date: 2020/5/15 0:07
 */
public class BulletTankCollider implements Collider {

    @Override
    public boolean collide(GameObject o1, GameObject o2) {

        if (o1 instanceof Bullet && o2 instanceof Tank) {
            Bullet b = (Bullet) o1;
            Tank t = (Tank) o2;
            return collideWith(b, t);


        } else if (o2 instanceof Bullet && o1 instanceof Tank) {
            return collide(o2, o1);
        }
        return true;

    }

    /**
     * 碰撞
     *
     * @param t
     */
    public boolean collideWith(Bullet b, Tank t) {
        if (b.getGroup() == t.getGroup()) return true;


        if (t.group == Group.BAD && b.rect.intersects(t.rect)) {//是否相交
            t.die();
            b.die();
            int eX = t.x + Tank.WIDTH / 2 - Explode.WIDTH / 2;
            int eY = t.y + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
            new Explode(eX, eY);
            return false;
        }
        return true;
    }

}
