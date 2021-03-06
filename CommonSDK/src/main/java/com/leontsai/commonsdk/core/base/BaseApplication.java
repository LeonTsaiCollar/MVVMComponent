package com.leontsai.commonsdk.core.base;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.multidex.MultiDexApplication;
import com.leontsai.commonsdk.core.base.delegate.AppDelegate;
import com.leontsai.commonsdk.core.base.delegate.AppLifecycle;

import com.leontsai.commonsdk.core.di.component.AppComponent;
import com.leontsai.commonsdk.utils.Preconditions;


public class BaseApplication extends MultiDexApplication implements IApp {
    private AppLifecycle mAppDelegate;

    /**
     * 这里会在 {@link BaseApplication#onCreate} 之前被调用,可以做一些较早的初始化
     * 常用于 MultiDex 以及插件化框架的初始化
     */
    @Override
    protected void attachBaseContext(@NonNull Context base) {
        super.attachBaseContext(base);
        if (mAppDelegate == null)
            mAppDelegate = new AppDelegate(base);
        mAppDelegate.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (mAppDelegate != null)
            this.mAppDelegate.onCreate(this);
    }

    /**
     * 在模拟环境中程序终止时会被调用
     */
    @Override
    public void onTerminate() {
        super.onTerminate();
        if (mAppDelegate != null)
            this.mAppDelegate.onTerminate(this);
    }


    @NonNull
    @Override
    public AppComponent getAppComponent() {
        Preconditions.checkNotNull(mAppDelegate, "%s cannot be null", AppDelegate.class.getName());
        Preconditions.checkState(mAppDelegate instanceof IApp, "%s must be implements %s", mAppDelegate.getClass().getName(), IApp.class.getName());
        return ((IApp) mAppDelegate).getAppComponent();
    }
}
