package com.example.factorypattern;

/**
 * Created by yangjun on 2016/7/25.
 */
public class FactoryA implements abstractFactory {
    @Override
    public ProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public ProductB createProductB() {
        return null;
    }
}

