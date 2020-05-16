package com.zsn.strategy;

import com.zsn.decorator.RectDecorator;
import com.zsn.decorator.TailDecorator;
import com.zsn.tank.*;

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

//       TODO  加了两次 bullet
//        GameModel.getInstance().add(
//                new RectDecorator(
//                        new TailDecorator(new Bullet(bX, bY, t.dir, t.group))));
        new Bullet(bX, bY, t.dir, t.group);

        if (t.group == Group.GOOD) new Thread(() -> new Audio("audio/tank_fire.wav").play()).start();
    }
}
