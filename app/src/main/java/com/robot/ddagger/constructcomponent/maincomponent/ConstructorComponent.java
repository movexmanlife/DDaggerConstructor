package com.robot.ddagger.constructcomponent.maincomponent;


import com.robot.ddagger.MainActivity;
import com.robot.ddagger.MainActivity2;
import com.robot.ddagger.component.AppComponent;
import com.robot.ddagger.component.PerActivity;

import dagger.Component;


@PerActivity
@Component(dependencies = AppComponent.class, modules = ConstructorModule.class)
public interface ConstructorComponent {
    void inject(MainActivity2 mainActivity2);
}
