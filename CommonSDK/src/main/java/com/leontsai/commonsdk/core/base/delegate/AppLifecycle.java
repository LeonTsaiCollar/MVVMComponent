package com.leontsai.commonsdk.core.base.delegate;

import android.app.Application;
import android.content.Context;
import androidx.annotation.NonNull;

public interface AppLifecycle {
    void attachBaseContext(@NonNull Context base);

    void onCreate(@NonNull Application application);

    void onTerminate(@NonNull Application application);
}
