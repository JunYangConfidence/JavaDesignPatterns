package com.example.vistorpattern;

/**
 * Created by yangjun on 2016/8/29.
 */
public class TeacherCandidate extends Candidate {
    // 教学反馈分
    private int teachingFeedbackScore;

    public TeacherCandidate(String name, String sex, String age, String identity, String numOfPapers) {
        super(name, sex, age, identity, numOfPapers);
    }

    public void setTeachingFeedbackScore(int teachingFeedbackScore) {
        this.teachingFeedbackScore = teachingFeedbackScore;
    }

    public int getTeachingFeedbackScore() {
        return teachingFeedbackScore;
    }

    @Override
    protected void accept(IVistor vistor) {
        vistor.vistor(this);
    }
}
