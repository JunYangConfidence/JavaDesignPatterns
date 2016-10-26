package com.example.vistorpattern;

import com.example.logutils.LogFactory;

/**
 * Created by yangjun on 2016/6/7.
 */
public class Vistor implements IVistor {
    @Override
    public void vistor(CommonEmployee commonEmployee) {
        LogFactory.log("员工信息："+getCommonInfo(commonEmployee));
    }

    @Override
    public void vistor(ManagerEmployee managerEmployee) {
        LogFactory.log("经理信息："+getManagerInfo(managerEmployee));
    }

    @Override
    public void vistor(TeacherCandidate teacherCandidate) {
        LogFactory.log("教师信息："+getTeacherInfo(teacherCandidate));
    }

    @Override
    public void vistor(StudentCandidate studentCandidate) {
        LogFactory.log("学生信息："+getStudentInfo(studentCandidate));
    }

    private String getBasicInfo(Candidate candidate){
        String info = "";
        String name ="姓名："+candidate.getName();
        String sex = "性别："+candidate.getSex();
        String age = "年龄："+candidate.getAge();
        String identity = "身份："+candidate.getIdentity();
        String numOfPapers = "发表论文数量："+candidate.getNumOfPapers();
        info = name + "\t" + sex + "\t" + age + "\t" + identity + "\t" + numOfPapers +"\t";
        return info;

    }

    private String getTeacherInfo(TeacherCandidate teacherCandidate){
        int teachingFeedbackScore = teacherCandidate.getTeachingFeedbackScore();
        String teachingFBScor = "教学反馈分数："+teachingFeedbackScore;
        String teacherInfo = this.getBasicInfo(teacherCandidate)+teachingFBScor;
        return teacherInfo;
    }

    private String getStudentInfo(StudentCandidate studentCandidate){
        int averageScore = studentCandidate.getAverageScore();
        String studentScore = "平均成绩："+averageScore;
        String studentInfo = this.getBasicInfo(studentCandidate) + studentScore;
        return studentInfo;
    }

    //组装基本信息
    private String getBasicInfo(Employee employee){
        String info = "姓名："+employee.getName()+"\t";
        info = info + "性别： " + (employee.getSex() == Employee.FEMALE?"女":"男")
                + "\t";
        info = info + "薪水： " + employee.getSalary() + "\t";
        return info;
    }

    //组装出部门经理的信息
    private String getManagerInfo(ManagerEmployee manager) {
        String basicInfo = this.getBasicInfo(manager);
        String otherInfo = "业绩： " + manager.getPerformance() + "\t";
        return basicInfo+otherInfo;
    }

    //组装出普通员工的信息
    private String getCommonInfo(CommonEmployee commonEmployee){
        String basicInfo = this.getBasicInfo(commonEmployee);
        String otherInfo = "工作： "+commonEmployee.getJob()+"\t";
        return basicInfo + otherInfo;
    }
}
