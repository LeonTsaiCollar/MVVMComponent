
package com.leontsai.commonsdk.core.base.delegate;


import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import com.alibaba.android.arouter.launcher.ARouter;
import com.leontsai.commonsdk.BuildConfig;
import com.leontsai.commonsdk.core.base.IApp;
import com.leontsai.commonsdk.core.base.integration.ConfigModule;
import com.leontsai.commonsdk.core.base.integration.ManifestParser;
import com.leontsai.commonsdk.core.di.component.AppComponent;
import com.leontsai.commonsdk.core.di.component.DaggerAppComponent;
import com.leontsai.commonsdk.utils.Preconditions;

import java.util.ArrayList;
import java.util.List;


public class AppDelegate implements IApp, AppLifecycle {
    private Application mApplication;
    private AppComponent mAppComponent;
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
        mAppComponent = DaggerAppComponent
                .builder()
                .application(application)
                .build();

        mAppComponent.inject(this);
        if (BuildConfig.DEBUG){
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(application);
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

    @NonNull
    @Override
    public AppComponent getAppComponent() {
        Preconditions.checkNotNull(mAppComponent,
                "%s == null, first call %s#onCreate(Application) in %s#onCreate()",
                AppComponent.class.getName(), getClass().getName(), mApplication == null
                        ? Application.class.getName() : mApplication.getClass().getName());
        return mAppComponent;
    }
}

