package com.robot.ddagger.bean;

import android.content.Context;
import android.widget.Toast;

import javax.inject.Inject;

public class NumberView {
    private Context context;
    private Student student;

    /**
     * 这里注意在构造函数上面写上@Inject，作用类似于Module里面的Provider函数。
     */
    public NumberView(Context context, Student student) {
        this.context = context;
        this.student = student;
    }


    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void showInfo() {
        Toast.makeText(context, student.getName() + ", " + student.getAge(), Toast.LENGTH_SHORT).show();
    }
}
