package com.example.interpreterpattern.terminal;

import android.util.Log;

import com.example.interpreterpattern.Expression;

import java.util.HashMap;

/**
 * Created by yangjun on 2016/12/20.
 * 终结符类
 */

public class VarExpression extends Expression {
    private String m_key;
    public VarExpression(String key){
        this.m_key = key;
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return var.get(m_key);
    }
}
