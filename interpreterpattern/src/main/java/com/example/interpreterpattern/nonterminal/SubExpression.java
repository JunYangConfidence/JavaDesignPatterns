package com.example.interpreterpattern.nonterminal;

import com.example.interpreterpattern.Expression;

import java.util.HashMap;

/**
 * Created by yangjun on 2016/12/20.
 *
 */

public class SubExpression extends SymbolExpression {
    public SubExpression(Expression left, Expression right) {
        super(left, right);
    }

    @Override
    public int interpreter(HashMap<String, Integer> var) {
        return super.m_left.interpreter(var) - super.m_right.interpreter(var);
    }
}
