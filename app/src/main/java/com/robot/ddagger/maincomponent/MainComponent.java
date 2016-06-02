package com.robot.ddagger.maincomponent;


import com.robot.ddagger.MainActivity;
import com.robot.ddagger.bean.NumberView;
import com.robot.ddagger.bean.Student;
import com.robot.ddagger.component.AppComponent;
import com.robot.ddagger.component.PerActivity;

import javax.inject.Singleton;

import dagger.Component;


/**
 * Error:(14, 1) 错误: com.robot.ddagger.maincomponent.MainComponent (unscoped) cannot depend on scoped components:
 @Singleton com.robot.ddagger.component.AppComponent

 // 假如这里把MainComponent和MainModule上面的@PerActivity去掉。会出现上面的错误。

 @Component(dependencies = AppComponent.class, modules = MainModule.class)
 public interface MainComponent {
 void inject(MainActivity mainActivity);
 }

 由于Component和Module需要使用相同的scope。
 这里由于依赖了AppComponent，所以需要新加上一个scope来标识才行。

 */
@PerActivity
@Component(modules = MainModule.class)
public interface MainComponent {
    void inject(MainActivity mainActivity);
}
