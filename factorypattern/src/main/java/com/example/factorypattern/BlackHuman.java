package com.example.factorypattern;

/**
 * Created by yangjun on 2016/5/31.
 */
public class BlackHuman implements Human {
    @Override
    public void laugh() {
        LogFactory.log("非洲人笑了！！！");
    }

    @Override
    public void talk() {
        LogFactory.log("非洲人在说话！！！");
    }

    @Override
    public void cry() {
        LogFactory.log("非洲人哭了！！！");
    }
}
