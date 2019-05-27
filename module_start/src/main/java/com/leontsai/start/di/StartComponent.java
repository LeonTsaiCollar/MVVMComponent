package com.leontsai.start.di;

import androidx.lifecycle.ViewModel;
import com.leontsai.commonsdk.core.bean.StartBean;
import com.leontsai.commonsdk.core.di.component.AppComponent;
import com.leontsai.commonsdk.core.di.scope.ActivityScope;
import com.leontsai.start.MainActivity;
import com.leontsai.start.di.module.StartModule;

import dagger.BindsInstance;
import dagger.Component;


@ActivityScope
@Component(modules = StartModule.class, dependencies = AppComponent.class)
public interface StartComponent {
    void inject(MainActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder startBean(StartBean startBean);

        Builder appComponent(AppComponent appComponent);

        StartComponent build();
    }
}
