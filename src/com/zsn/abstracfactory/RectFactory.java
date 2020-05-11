package com.zsn.abstracfactory;

import com.zsn.tank.Dir;
import com.zsn.tank.Group;
import com.zsn.tank.Tank;
import com.zsn.tank.TankFrame;

/**
 * @Author: zsn
 * @Date: 2020/5/11 23:34
 */
public class RectFactory extends GameFactory {
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectTank(x,y,dir,group,tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectBullet(x,y,dir,group,tf);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new RectExplode(x,y,tf);
    }
}
