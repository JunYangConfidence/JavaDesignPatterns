package com.example.vistorpattern;

/**
 * Created by yangjun on 2016/6/7.
 */
public interface IVistor {
    public void vistor(CommonEmployee commonEmployee);
    public void vistor(ManagerEmployee managerEmployee);
    public void vistor(TeacherCandidate teacherCandidate);
    public void vistor(StudentCandidate studentCandidate);
}
