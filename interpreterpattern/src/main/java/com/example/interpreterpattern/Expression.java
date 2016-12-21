package com.example.interpreterpattern;

import java.util.HashMap;

/**
 * Created by yangjun on 2016/12/20.
 */

public abstract class Expression {

    /**
     * 解析公式和数值,其中var中的key值是是公式中的参数，value值是具体的数字
     * @param var 该参数相当于Context
     * @return 结果
     */
    public abstract int interpreter(HashMap<String,Integer> var);
}
