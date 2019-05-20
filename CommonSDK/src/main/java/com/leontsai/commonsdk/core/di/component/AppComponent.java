package com.leontsai.commonsdk.core.di.component;

import android.app.Application;
import com.google.gson.Gson;

import com.leontsai.commonsdk.core.base.delegate.AppDelegate;
import com.leontsai.commonsdk.core.di.module.AppModule;
import com.leontsai.commonsdk.core.di.module.ClientModule;
import com.lzy.okgo.OkGo;
import dagger.BindsInstance;
import dagger.Component;
import okhttp3.OkHttpClient;

import javax.inject.Singleton;

@Singleton
@Component(modules = {AppModule.class, ClientModule.class})
public interface AppComponent {
    void inject(AppDelegate delegate);

    Application getApplication();

    Gson getGson();

    OkGo getOkGo();

    @Component.Builder
    interface Builder {
        AppComponent build();

        @BindsInstance
        Builder application(Application application);

    }
}
