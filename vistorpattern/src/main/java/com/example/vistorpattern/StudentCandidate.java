package com.example.vistorpattern;

/**
 * Created by **
 * 学生候选者
 */
public class StudentCandidate extends Candidate {
    // 平均成绩
    private int averageScore;

    public StudentCandidate(String name, String sex, String age, String identity, String numOfPapers) {
        super(name, sex, age, identity, numOfPapers);
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    public int getAverageScore() {
        return averageScore;
    }

    @Override
    protected void accept(IVistor vistor) {
        vistor.vistor(this);
    }
}
