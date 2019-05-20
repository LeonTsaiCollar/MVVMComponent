
package com.leontsai.start.app;

import android.content.Context;
import com.leontsai.commonsdk.core.base.delegate.AppLifecycle;
import com.leontsai.commonsdk.core.base.integration.ConfigModule;


import java.util.List;


public final class ConfigModuleImpl implements ConfigModule {


    @Override
    public void injectAppLifecycle(Context context, List<AppLifecycle> lifecycles) {
        lifecycles.add(new AppLifecycleImpl());
    }
}
