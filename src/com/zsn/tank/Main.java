package com.zsn.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author: zsn
 * @Date: 2020/5/5 18:25
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf =new TankFrame();

//        初始化敌方坦克
        for (int i =0 ;i<5;i++){
            tf.tanks.add(new Tank(50+ i*80,200,Dir.DOWN,tf));
        }
        while (true){
            Thread.sleep(50);
            tf.repaint();
        }
    }
}
