package com.example.factorypattern;

/**
 * Created by yangjun on 2016/7/25.
 */
public class FactoryB implements Factory {
    @Override
    public ProductB createProduct() {
        return new ProductB();
    }
}
