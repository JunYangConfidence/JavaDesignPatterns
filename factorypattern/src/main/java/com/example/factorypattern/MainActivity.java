package com.example.factorypattern;

import android.app.Activity;
import android.os.Bundle;

import java.net.URL;

/**
 * Created by yangjun on 2016/5/31.
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
//        notParameter();
//        Product a = Factory.createProduct("a");
//        Product b = Factory.createProduct("b");
//        FactoryA factoryA = new FactoryA();
//        ProductA productA = factoryA.createProduct();
//
//        FactoryB factoryB = new FactoryB();
//        ProductB productB = factoryB.createProduct();

        FactoryA factoryA = new FactoryA();
        ProductA productA = factoryA.createProductA();
        ProductB productB = factoryA.createProductB();

        FactoryA factoryB = new FactoryA();
        ProductA producta = factoryB.createProductA();
        ProductB productb = factoryB.createProductB();

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        String path = "com.example.factorypattern";
//        String packageName = getPackageName();
//        LogFactory.log("packageName = "+packageName);
//        String replace = packageName.replace('.', '/');
//        URL resource = classLoader.getResource("Human.java");

        LogFactory.log("classLoader.getResource = "+classLoader.getResource("com/example/factorypattern"));
        URL resource = MainActivity.class.getResource("/");
        LogFactory.log("resource =" +resource);
//        testClassUtil util = new testClassUtil();
//        util.getAllClassByInterface(Human.class);
    }
    private void testCreateHuman(){
        Human human = HumanFactory.createHuman(YellowHuman.class);
        human.cry();
        human.laugh();
        human.talk();
    }
    private void notParameter(){
        for (int i = 0;i<2;i++){
            Human human = HumanFactory.createHuman();
            if(null != human){
                human.cry();
                human.laugh();
                human.talk();
            }

        }

    }
}
