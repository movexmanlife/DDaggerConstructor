package com.robot.ddagger.maincomponent;

import android.content.Context;

import com.robot.ddagger.App;
import com.robot.ddagger.bean.NumberView;
import com.robot.ddagger.bean.Student;
import com.robot.ddagger.component.PerActivity;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@PerActivity
@Module
public class MainModule {
    private Context context;
    public MainModule(Context context) {
        this.context = context;
    }

    @Provides
    public NumberView providerNumberView() {
        return new NumberView(context, new Student(43, "number"));
    }
}
