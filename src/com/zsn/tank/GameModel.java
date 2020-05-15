package com.zsn.tank;

import com.zsn.cor.BulletTankCollider;
import com.zsn.cor.Collider;
import com.zsn.cor.ColliderChain;
import com.zsn.cor.TankTankCollider;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zsn
 * @Date: 2020/5/14 23:22
 */
//对TankFrame是门面模式，对内部是调停者
public class GameModel {

    private static final GameModel INSTANCE = new GameModel();


    static {
        INSTANCE.init();
    }

    Tank myTank ;
//    java.util.List<Bullet> bullets = new ArrayList<>(); //不清的话 就会内存泄漏
//    java.util.List<Tank> tanks = new ArrayList<>();
//    List<Explode> explodes = new ArrayList<>();


    private List<GameObject> objects = new ArrayList<>();

//    Collider collider = new BulletTankCollider();
//    Collider collider2 = new TankTankCollider();

    ColliderChain chain = new ColliderChain();


    public static GameModel getInstance() {
        return INSTANCE;
    }
    private GameModel() {

    }

    private void init(){
        myTank = new Tank(200, 400, Dir.DOWN, Group.GOOD);
        int initTankCount = Integer.parseInt((String) PropertyMgr.get("initTankCount"));
//        初始化敌方坦克
        for (int i = 0; i < initTankCount; i++) {
            new Tank(50 + i * 80, 200, Dir.DOWN, Group.BAD);
        }

        add(new Wall(150, 150, 200, 50));
        add(new Wall(550, 150, 200, 50));
        add(new Wall(300, 300, 50, 200));
        add(new Wall(550, 300, 50, 200));
    }

    public void add(GameObject go) {
        this.objects.add(go);
    }

    public void remove(GameObject go) {
        this.objects.remove(go);
    }

    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.WHITE);
//        g.drawString("子弹的数量:" + bullets.size(), 10, 60);
//        g.drawString("敌人的数量:" + tanks.size(), 10, 80);
//        g.drawString("爆炸的数量:" + explodes.size(), 10, 100);
        g.setColor(c);
        myTank.paint(g);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).paint(g);
        }


//       碰撞检测  collision detect

        for (int i = 0; i < objects.size(); i++) {//Comparator.compare(o1,o2)
            for (int j = i + 1; j < objects.size(); j++) {

                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);

                chain.collide(o1, o2);
//                o1.collideWith(o2);
            }

        }

//        for (int i = 0; i < bullets.size(); i++) {
//            for (int j = 0; j < tanks.size(); j++) {
//
//                bullets.get(i).collideWith(tanks.get(j));
//            }
//        }
//        e.paint(g);

//        x += 50;
//        y += 50;
    }

    public Tank getMainTank() {
        return myTank;
    }
}
