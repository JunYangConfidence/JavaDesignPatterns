package com.example.factorypattern;

/**
 * Created by yangjun on 2016/5/31.
 * 该接口可以理解为抽象产品
 */
public interface Human {
    // 表示人类会笑
    public void laugh();
    // 表示人类会说话
    public void talk();
    // 表示人类会伤心
    public void cry();
}
