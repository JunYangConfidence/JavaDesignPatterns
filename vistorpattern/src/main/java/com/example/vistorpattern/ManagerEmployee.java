package com.example.vistorpattern;

/**
 * Created by yangjun on 2016/6/7.
 */
public class ManagerEmployee extends Employee {

    //经理用业绩来衡量
    private String performance;

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public String getPerformance() {
        return this.performance;
    }

    @Override
    public void accept(IVistor vistor) {
        vistor.vistor(this);
    }
}
