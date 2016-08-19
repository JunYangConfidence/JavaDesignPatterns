package com.example.factorypattern;

/**
 * Created by yangjun on 2016/5/31.
 */
public class WhiteHuman implements Human {
    @Override
    public void laugh() {
        LogFactory.log("白种人笑了！！！");
    }

    @Override
    public void talk() {
        LogFactory.log("白种人在说话！！！");
    }

    @Override
    public void cry() {
        LogFactory.log("白种人在哭！！！");
    }
}
