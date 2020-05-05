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
        TankFrame frame =new TankFrame();
        while (true){
            Thread.sleep(50);
            frame.repaint();
        }
    }
}
