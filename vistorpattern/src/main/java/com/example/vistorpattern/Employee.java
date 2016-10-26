package com.example.vistorpattern;

/**
 * Created by yangjun on 2016/6/7.
 */
public abstract class Employee {
    // 0代表男性
    public final static int MALE = 0;
    // 1代表女性
    public final static int FEMALE = 1;

    private String name;
    private int salary;
    private int sex;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalary() {
        return this.salary;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSex() {
        return this.sex;
    }

    public abstract void accept(IVistor vistor);
}
