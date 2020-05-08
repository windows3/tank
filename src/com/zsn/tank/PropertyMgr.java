package com.zsn.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author: zsn
 * @Date: 2020/5/9 0:35
 */
public class PropertyMgr {

    static Properties props = new Properties();

    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object get(String key) {
        if (props == null) return null;
        return props.get(key);
    }

    public static void main(String[] args) {
        System.out.println( props.get("initTankCount"));
    }
}
