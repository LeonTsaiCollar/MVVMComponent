package com.leontsai.commonsdk.di.module;

import com.google.gson.Gson;

import javax.inject.Singleton;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.cookie.CookieJarImpl;
import com.lzy.okgo.cookie.store.DBCookieStore;
import com.lzy.okgo.https.HttpsUtils;
import com.lzy.okgo.interceptor.HttpLoggingInterceptor;
import com.lzy.okgo.model.HttpHeaders;
import com.lzy.okgo.model.HttpParams;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

@Module
public abstract class AppModule {


    @Singleton
    @Provides
    static Gson provideGson() {
        return new Gson();
    }



}
