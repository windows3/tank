package com.zsn.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @Author: zsn
 * @Date: 2020/5/7 1:47
 */
public class ResourceMgr {
    public static BufferedImage tankL, tankU, tankR, tankD;
    public static BufferedImage bulletL,bulletU,bulletR,bulletD;
    public static BufferedImage [] explodes =new BufferedImage[16];

    static {
        try {
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            tankL = ImageUtil.rotateImage(tankU,-90);
            tankR = ImageUtil.rotateImage(tankU,90);
            tankD = ImageUtil.rotateImage(tankU,180);


            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.png"));
            bulletL = ImageUtil.rotateImage(bulletU, -90);
            bulletR = ImageUtil.rotateImage(bulletU, 90);
            bulletD = ImageUtil.rotateImage(bulletU, 180);
            for(int i=0;i<explodes.length;i++)
                explodes[i]=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
