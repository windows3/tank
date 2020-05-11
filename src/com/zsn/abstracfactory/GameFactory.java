package com.zsn.abstracfactory;

import com.zsn.tank.Dir;
import com.zsn.tank.Group;
import com.zsn.tank.TankFrame;

/**
 * @Author: zsn
 * @Date: 2020/5/11 23:11
 */
public abstract class GameFactory {
   public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf);

    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf);

    public abstract BaseExplode createExplode(int x, int y, TankFrame tf);
}
