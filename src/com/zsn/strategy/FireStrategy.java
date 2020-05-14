package com.zsn.strategy;

/**
 * @Author: zsn
 * @Date: 2020/5/10 16:13
 */
//开火设计模式
@FunctionalInterface
public interface FireStrategy<T> {

    public void fire(T o);
}
