package com.leontsai.commonsdk.di.module;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class AppModule {


    @Singleton
    @Provides
    static Gson provideGson() {
        return new Gson();
    }

}
