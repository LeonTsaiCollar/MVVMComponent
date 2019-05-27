package com.leontsai.home.app;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;
import com.leontsai.commonsdk.core.base.delegate.AppLifecycle;
import com.leontsai.commonsdk.utils.LogUtil;

public class AppLifecycleImpl implements AppLifecycle {
    @Override
    public void attachBaseContext(@NonNull Context base) {
        LogUtil.d("home AppLifecycleImpl attachBaseContext");

    }

    @Override
    public void onCreate(@NonNull Application application) {
        LogUtil.d("home AppLifecycleImpl onCreate");
    }

    @Override
    public void onTerminate(@NonNull Application application) {
        LogUtil.d("home AppLifecycleImpl onTerminate");
    }
}
