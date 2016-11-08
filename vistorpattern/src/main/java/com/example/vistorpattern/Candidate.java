package com.example.vistorpattern;

/**
 * Created by yangjun on 2016/8/29.
 * hahah
 */
public abstract class Candidate {
    private String name;
    private String sex;
    private String age;
    //身份
    private String identity;
    // 论文数量
    private String numOfPapers;

    public Candidate(String name,String sex,String age,String identity,String numOfPapers){
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.identity = identity;
        this.numOfPapers = numOfPapers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getIdentity() {
        return identity;
    }

    public void setNumOfPapers(String numOfPapers) {
        this.numOfPapers = numOfPapers;
    }

    public String getNumOfPapers() {
        return numOfPapers;
    }

    protected abstract void accept(IVistor vistor);
}
