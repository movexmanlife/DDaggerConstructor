package com.robot.ddagger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.robot.ddagger.bean.ConstructorView;
import com.robot.ddagger.bean.Student;
import com.robot.ddagger.constructorcomponent.ConstructorModule;
import com.robot.ddagger.constructorcomponent.DaggerConstructorComponent;
import com.robot.ddagger.maincomponent.DaggerMainComponent;

import javax.inject.Inject;

public class MainActivity2 extends AppCompatActivity {
    Button btn;
    Button btn2;

    @Inject
    ConstructorView constructorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        btn2 = (Button) findViewById(R.id.btn2);

        DaggerConstructorComponent.builder().appComponent(((App)getApplication()).getAppComponent()).constructorModule(new ConstructorModule()).build().inject(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                test2();
            }
        });
    }

    private void test() {
        Student student = constructorView.getStudent();
        Toast.makeText(getApplicationContext(), student.getName() + ", " + student.getAge(), Toast.LENGTH_SHORT).show();
    }

    private void test2() {
        constructorView.showInfo();
    }

}
