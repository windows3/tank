package com.zsn.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @Author: zsn
 * @Date: 2020/5/5 19:59
 */
public class TankFrame extends Frame {
    int x = 200;
    int y = 200;

    public TankFrame() throws HeadlessException {
        setSize(800, 600);//大小
        setResizable(false);//不让改大小
        setTitle("tank war");//标题
        setVisible(true);
        this.addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {//监听器
            @Override
            public void windowClosing(WindowEvent e) {//可以关闭了
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        g.fillRect(x, y, 50, 50);
        x += 50;
//        y += 50;
    }
    class MyKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            x+=50;
            y+=50;
//            repaint();//默认调用paint
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key Released");
        }
    }

}
