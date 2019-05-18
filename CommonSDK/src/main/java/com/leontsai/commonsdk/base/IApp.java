package com.leontsai.commonsdk.base;

import androidx.annotation.NonNull;

import com.leontsai.commonsdk.di.component.AppComponent;


/**
 * ================================================
 * 框架要求框架中的每个 {@link android.app.Application} 都需要实现此类, 以满足规范
 * @see BaseApplication
 * ================================================
 */
public interface IApp {

    @NonNull
    AppComponent getAppComponent();
}
