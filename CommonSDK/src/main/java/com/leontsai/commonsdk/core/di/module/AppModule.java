package com.leontsai.commonsdk.core.di.module;

import com.google.gson.Gson;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;

@Module
public abstract class AppModule {


    @Singleton
    @Provides
    static Gson provideGson() {
        return new Gson();
    }



}
