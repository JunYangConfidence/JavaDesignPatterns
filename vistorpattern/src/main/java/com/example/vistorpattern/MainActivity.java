package com.example.vistorpattern;

import android.app.Activity;
import android.os.Bundle;

import com.example.logutils.LogFactory;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by yangjun on 2016/6/7.
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        TeacherCandidate teacher_zhang = new TeacherCandidate("张大帅","男","48","教师","20");
        TeacherCandidate teacher_li = new TeacherCandidate("李娟","女","52","教师","8");

        teacher_zhang.setTeachingFeedbackScore(88);
        teacher_li.setTeachingFeedbackScore(95);

        StudentCandidate studen_x = new StudentCandidate("小明", "男", "22", "学生", "1");
        StudentCandidate studen_l = new StudentCandidate("小丽", "女", "21", "学生", "3");

        studen_x.setAverageScore(70);
        studen_l.setAverageScore(97);

        CandidateList candidateList = new CandidateList();
        candidateList.addCandidate(teacher_zhang);
        candidateList.addCandidate(teacher_li);
        candidateList.addCandidate(studen_l);
        candidateList.addCandidate(studen_x);

        candidateList.accept(new Vistor());
        /*for (Employee employee : mockEmployee()){
            employee.accept(new Vistor());
        }

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String path = "com/example/vistorpattern";
        URL resource = classLoader.getResource(path);
        LogFactory.log("resource = "+resource);*/
    }

    //模拟公司的人员情况，将数据当做从持久层传递过来的
    private ArrayList<Employee> mockEmployee(){
        ArrayList<Employee> empList = new ArrayList<Employee>();

        CommonEmployee zhangSan = new CommonEmployee();
        zhangSan.setName("张三");
        zhangSan.setSex(Employee.MALE);
        zhangSan.setSalary(100000);
        zhangSan.setJob("开发");

        empList.add(zhangSan);

        CommonEmployee xiaoHong = new CommonEmployee();
        xiaoHong.setName("小红");
        xiaoHong.setSex(Employee.FEMALE);
        xiaoHong.setSalary(80000);
        xiaoHong.setJob("HR");

        empList.add(xiaoHong);

        ManagerEmployee wangWu = new ManagerEmployee();
        wangWu.setName("王五");
        wangWu.setSex(Employee.MALE);
        wangWu.setSalary(5000000);
        wangWu.setPerformance("业绩还行啊！");

        empList.add(wangWu);
        return empList;
    }
}
