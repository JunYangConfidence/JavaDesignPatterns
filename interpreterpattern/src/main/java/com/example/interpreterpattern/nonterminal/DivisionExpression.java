package com.example.interpreterpattern.nonterminal;

import android.util.Log;

import com.example.interpreterpattern.Expression;

import java.util.HashMap;

/**
 * Created by yangjun on 2016/12/20.
 */

public class DivisionExpression extends SymbolExpression {
    public DivisionExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        int right = super.m_right.interpreter(var);
        Log.d("test","right = "+right);
        if (0 == right){
            Log.d("test","除数不能为零 ！！！");
        }else{
            return super.m_left.interpreter(var)/right;
        }
        return 0;
    }
}
