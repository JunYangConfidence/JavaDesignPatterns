package com.example.factorypattern;

/**
 * Created by yangjun on 2016/7/25.
 */
public class Singleton {
    private volatile static Singleton instance = null;
    private Singleton(){}
    public static Singleton getInstance(){
        if (null != instance){                     //第一次检查
            synchronized (Singleton.class){        //加同步锁
                if (null != instance){             //第二次检查
                    instance = new Singleton();    //创建对象
                }
            }
        }
        return instance;
    }
}
 /* private Singleton(){}
    private static class SingletonHolder{
        private static Singleton instance = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHolder.instance;      //这里才会导致 SingletonHolder类被初始化
    }*/