package com.leontsai.commonsdk.base.integration;

import android.content.Context;

import com.leontsai.commonsdk.base.delegate.AppLifecycle;

import java.util.List;

/**
 * ================================================
 * {@link ConfigModule} 可以给框架配置一些参数,需要实现 {@link ConfigModule} 后,在 AndroidManifest 中声明该实现类
 * ================================================
 */
public interface ConfigModule {

    /**
     * 使用{@link AppLifecycles}在Application的生命周期中注入一些操作
     *
     * @param context
     * @param lifecycles
     */
    void injectAppLifecycle(Context context, List<AppLifecycle> lifecycles);

}
