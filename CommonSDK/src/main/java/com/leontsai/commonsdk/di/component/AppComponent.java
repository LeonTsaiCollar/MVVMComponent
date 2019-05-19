package com.leontsai.commonsdk.di.component;

import android.app.Application;

import com.google.gson.Gson;
import com.leontsai.commonsdk.base.delegate.AppDelegate;
import com.leontsai.commonsdk.di.module.AppModule;
import com.leontsai.commonsdk.di.module.ClientModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import okhttp3.OkHttpClient;

@Singleton
@Component(modules = {AppModule.class, ClientModule.class})
public interface AppComponent {
    void inject(AppDelegate delegate);

    Application getApplication();

    Gson getGson();

    OkHttpClient getOkHttpClient();


    @Component.Builder
    interface Builder{
        AppComponent build();
        @BindsInstance
        Builder application(Application application);

    }
}
