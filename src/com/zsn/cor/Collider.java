package com.zsn.cor;

import com.zsn.tank.GameObject;

/**
 * @Author: zsn
 * @Date: 2020/5/15 0:05
 */
public interface Collider {

     boolean collide(GameObject o1, GameObject o2);

}
