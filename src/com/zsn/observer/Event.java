package com.zsn.observer;

/**
 * @Author: zsn
 * @Date: 2020/5/17 2:12
 */
public abstract class Event<T> {
    abstract T getSource();
}
