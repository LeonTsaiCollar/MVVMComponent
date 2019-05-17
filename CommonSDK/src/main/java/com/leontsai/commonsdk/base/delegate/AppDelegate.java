
package com.leontsai.commonsdk.base.delegate;


import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;


import com.leontsai.commonsdk.base.IApp;
import com.leontsai.commonsdk.base.integration.ConfigModule;
import com.leontsai.commonsdk.base.integration.ManifestParser;

import java.util.ArrayList;
import java.util.List;


public class AppDelegate implements IApp, AppLifecycle {
    private Application mApplication;
    private List<ConfigModule> mModules;
    private List<AppLifecycle> mAppLifecycles = new ArrayList<>();


    public AppDelegate(@NonNull Context context) {
        this.mModules = new ManifestParser(context).parse();
        for (ConfigModule module : mModules) {
            module.injectAppLifecycle(context, mAppLifecycles);
        }
    }

    @Override
    public void attachBaseContext(@NonNull Context base) {
        for (AppLifecycle lifecycle : mAppLifecycles) {
            lifecycle.attachBaseContext(base);
        }
    }

    @Override
    public void onCreate(@NonNull Application application) {
        this.mApplication = application;
        //执行框架外部, 开发者扩展的 App onCreate 逻辑
        for (AppLifecycle lifecycle : mAppLifecycles) {
            lifecycle.onCreate(mApplication);
        }
    }


    @Override
    public void onTerminate(@NonNull Application application) {
        if (mAppLifecycles != null && mAppLifecycles.size() > 0) {
            for (AppLifecycle lifecycle : mAppLifecycles) {
                lifecycle.onTerminate(mApplication);
            }
        }
        this.mAppLifecycles = null;
        this.mApplication = null;
    }

}

