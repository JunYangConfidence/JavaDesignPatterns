package com.example.vistorpattern;

/**
 * Created by yangjun on 2016/6/7.
 */
public class CommonEmployee extends Employee {

    private String job;

    public void setJob(String job) {
        this.job = job;
    }

    public String getJob() {
        return this.job;
    }

    @Override
    public void accept(IVistor vistor) {
        vistor.vistor(this);
    }
}
