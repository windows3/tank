package com.zsn.flyweight;

/**
 * @Author: zsn
 * @Date: 2020/5/17 16:39
 */
// String 就是享元
public class TestString {
    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        String s4 = new String("abc");

        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false
        System.out.println(s3.intern()==s1);//true  intern()拿常量池的对象
        System.out.println(s3.intern()==s4.intern());//true
    }


}
