package com.example.interpreterpattern.nonterminal;

import com.example.interpreterpattern.Expression;

/**
 * Created by yangjun on 2016/12/20.
 * 符号类
 *
 */

public abstract class SymbolExpression extends Expression {
    protected Expression m_left;
    protected Expression m_right;
    public SymbolExpression(Expression left,Expression right){
        this.m_left = left;
        this.m_right = right;
    }
}
