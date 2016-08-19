package com.example.factorypattern;

import java.util.List;
import java.util.Random;

/**
 * Created by yangjun on 2016/5/31.
 */
public class HumanFactory {
    public static Human createHuman(Class c) {
        Human human = null;
        try {
            Class a = Class.forName(c.getName());
            LogFactory.log("a = "+a);
            human = (Human) a.newInstance();
            LogFactory.log("human = "+human);
        } catch (ClassNotFoundException e) {
            LogFactory.log("找不到这个人类");
            e.printStackTrace();
        } catch (InstantiationException e) {
            LogFactory.log("必须指定人类颜色");
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            LogFactory.log("定义人类错误");
            e.printStackTrace();
        }
        return human;
    }

    public static Human createHuman(){
        Human human = null;
        List<Class> allClassByInterface = ClassUtils.getAllClassByInterface(Human.class);
        int size = allClassByInterface.size();
        LogFactory.log("allClassByInterface = "+size);
        if (0 != size){
            for (int i = 0;i < allClassByInterface.size();i ++){
                LogFactory.log("classByInterface = "+allClassByInterface.get(i));
            }
            Random random = new Random();
            int i = random.nextInt(allClassByInterface.size());
            human = createHuman(allClassByInterface.get(i));
        }
        return human;
    }
}
