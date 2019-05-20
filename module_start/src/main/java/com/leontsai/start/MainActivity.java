package com.leontsai.start;

import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.Gson;
import com.leontsai.commonsdk.core.base.IApp;
import com.leontsai.commonsdk.core.hub.RouterHub;
import com.leontsai.commonsdk.utils.LogUtil;

import com.leontsai.start.di.DaggerStartComponent;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.model.Response;
import okhttp3.*;

import javax.inject.Inject;
import java.io.IOException;


@Route(path = RouterHub.START_MAINACTIVITY)
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity_main);

        DaggerStartComponent.builder().appComponent(((IApp) getApplication()).getAppComponent()).build().inject(this);


        findViewById(R.id.startApp).setOnClickListener(
                v -> {

                    OkGo.get("https://restapi.amap.com/v3/weather/weatherInfo?key=ca3b0886701109bca675f5ba72fb29f0&city=330109")//
                            .tag(this)//
                            .cacheMode(CacheMode.NO_CACHE)//
                            .cacheKey("no_cache")   //对于无缓存模式,该参数无效
                            .cacheTime(5000)        //对于无缓存模式,该时间无效
                            .execute(new AbsCallback<Object>() {
                                @Override
                                public void onSuccess(Response<Object> response) {

                                }

                                @Override
                                public Object convertResponse(okhttp3.Response response) throws Throwable {
                                    return null;
                                }
                            });

                }
        );


    }
}
