package com.example.interpreterpattern.nonterminal;

import android.util.Log;

import com.example.interpreterpattern.Expression;

import java.util.HashMap;

/**
 * Created by yangjun on 2016/12/20.
 * 乘法解释器（非终结符类）
 */

public class MultiplyExpression extends SymbolExpression {
    public MultiplyExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return super.m_left.interpreter(var) * super.m_right.interpreter(var);
    }
}
