package com.leontsai.start.di;

import android.app.Activity;


import com.leontsai.commonsdk.core.di.component.AppComponent;
import com.leontsai.commonsdk.core.di.scope.ActivityScope;
import com.leontsai.start.MainActivity;
import com.leontsai.start.di.module.StartModule;

import dagger.Component;

@ActivityScope
@Component(modules = StartModule.class, dependencies = AppComponent.class)
public interface StartComponent {
    void inject(MainActivity activity);
}
