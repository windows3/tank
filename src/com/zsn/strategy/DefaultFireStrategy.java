package com.zsn.strategy;

import com.zsn.tank.Audio;
import com.zsn.tank.Bullet;
import com.zsn.tank.Group;
import com.zsn.tank.Tank;

/**
 * @Author: zsn
 * @Date: 2020/5/10 16:16
 */
//做成单例
public class DefaultFireStrategy implements FireStrategy<Tank> {

    @Override
    public void fire(Tank t) {

        int bX = t.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int bY = t.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;

        new Bullet(bX, bY, t.dir, t.group);
        if (t.group == Group.GOOD) new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
    }
}
