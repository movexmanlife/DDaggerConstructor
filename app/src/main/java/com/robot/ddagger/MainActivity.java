package com.robot.ddagger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.robot.ddagger.bean.ConstructorView;
import com.robot.ddagger.bean.NumberView;
import com.robot.ddagger.bean.Student;
import com.robot.ddagger.maincomponent.DaggerMainComponent;
import com.robot.ddagger.maincomponent.MainModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    NumberView numberView;
    Button btn;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        btn2 = (Button) findViewById(R.id.btn2);

        DaggerMainComponent.builder().mainModule(new MainModule(this)).build().inject(this);

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
        Student student = numberView.getStudent();
        Toast.makeText(getApplicationContext(), student.getName() + ", " + student.getAge(), Toast.LENGTH_SHORT).show();
    }

    private void test2() {
        numberView.showInfo();
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }

}
