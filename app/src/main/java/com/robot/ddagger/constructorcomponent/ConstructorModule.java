package com.robot.ddagger.constructorcomponent;

import android.app.Activity;
import android.content.Context;

import com.robot.ddagger.bean.NumberView;
import com.robot.ddagger.bean.Student;
import com.robot.ddagger.component.PerActivity;

import dagger.Module;
import dagger.Provides;


/**
 * 从这里我们可以知道其实Module里面啥都没有提供也是可以的，
 *
 * https://github.com/gzsll/TLint
 *
 * （1）项目中很多的Presenter，比如说这里的LoginPresenter。
 * 全都是在构造函数中@Inject，比如说@Inject LoginPresenter。
 * 它的参数全部是依赖的。而它的module里面却没有提供相关的数据。
 *
 * （2）  @Inject public ThreadListPresenter(String fid, ForumApi forumApi, GameApi gameApi,
 UserStorage userStorage) 还有这样子的情况。
 这里在Module中提供了一些数据。

 @Module public class ThreadListModule {

 private String fid;

 public ThreadListModule(String fid) {
 this.fid = fid;
 }

 @Provides String provideFid() {
 return fid;
 }
 }
 */
@PerActivity
@Module
public class ConstructorModule {

    public ConstructorModule() {
    }
}
