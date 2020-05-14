package com.zsn.cor;

import com.zsn.tank.GameObject;
import com.zsn.tank.PropertyMgr;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zsn
 * @Date: 2020/5/15 0:43
 */
//责任链
public class ColliderChain implements Collider {
    private List<Collider> colliders = new LinkedList<>();

    public ColliderChain() {
        String colliders = (String) PropertyMgr.get("colliders");
        String[] arr = colliders.split(",");
        try {
            for (int i = 0; i < arr.length; i++) {

                add((Collider) Class.forName(arr[i]).getDeclaredConstructor().newInstance());

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        add(new BulletTankCollider());
//        add(new TankTankCollider());
    }

    public void add(Collider c) {
        colliders.add(c);
    }

    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            if (!colliders.get(i).collide(o1, o2)) {
                return false;
            }
        }
        return true;
    }
}
