package com.example.interpreterpattern;

import com.example.interpreterpattern.nonterminal.AddExpression;
import com.example.interpreterpattern.nonterminal.DivisionExpression;
import com.example.interpreterpattern.nonterminal.MultiplyExpression;
import com.example.interpreterpattern.nonterminal.SubExpression;
import com.example.interpreterpattern.terminal.VarExpression;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by yangjun on 2016/12/20.
 * 解释器封装类
 */

public class Calculater {

    private Expression expression;

    public void build(String strExp){
        Expression left = null;
        Expression right = null;
        Stack<Expression> stack = new Stack<Expression>();
        char[] chars = strExp.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]){
                case '+':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(chars[++i]));
                    stack.push(new AddExpression(left,right));
                    break;
                case '-':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(chars[++i]));
                    stack.push(new SubExpression(left,right));
                    break;
                case '*':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(chars[++i]));
                    stack.push(new MultiplyExpression(left,right));
                    break;
                case '/':
                    left = stack.pop();
                    right = new VarExpression(String.valueOf(chars[++i]));
                    stack.push(new DivisionExpression(left,right));
                    break;
                default:
                    stack.push(new VarExpression(String.valueOf(chars[i])));
            }
        }
        this.expression = stack.pop();
    }
    public int compute(HashMap<String, Integer> var){
        return expression.interpreter(var);
    }

}
