package com.example.factorypattern;

import android.util.Log;

/**
 * Created by yangjun on 2016/5/31.
 */
public class YellowHuman implements Human {
    @Override
    public void laugh() {
        LogFactory.log("黄种人笑了！！！");
    }

    @Override
    public void talk() {
        LogFactory.log("黄种人在说话！！！");
    }

    @Override
    public void cry() {
        LogFactory.log("黄种人哭了！！！");
    }
}
