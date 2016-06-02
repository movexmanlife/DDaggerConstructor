package com.robot.ddagger.bean;

import android.content.Context;
import android.widget.Toast;

import javax.inject.Inject;

public class ConstructorView {
    private Context context;
    private Student student;

    @Inject
    public ConstructorView(Context context, Student student) {
        this.context = context;
        this.student = student;
    }

    /**
     * 这里注意在构造函数上面写上@Inject，作用类似于Module里面的Provider函数。
     *
     * 那么要非常注意，此时在使用这个的时候，参数必然也是注入的，也就是需要添加依赖的Component了。
     * dependencies = AppComponent.class
     */

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
