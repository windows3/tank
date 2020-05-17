package com.zsn.observer;

/**
 * @Author: zsn
 * @Date: 2020/5/17 2:18
 */
public interface Observer<T> {
    void actionOnFire(T t);
}
