package com.example.factorypattern;

import android.widget.Switch;

/**
 * Created by yangjun on 2016/7/25.
 */
public interface Factory {
    public Product createProduct();
}

/*public class Factory {
    public static Product createProduct(String type){
        switch (type){
            case "a":
                return new ProductA();
            case "b":
                return new ProductB();
            default:
                break;
        }
        return null;
    }
}*/
