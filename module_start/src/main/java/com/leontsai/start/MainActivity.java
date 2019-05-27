package com.leontsai.start;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.lifecycle.ViewModelProviders;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.leontsai.commonsdk.core.base.IApp;
import com.leontsai.commonsdk.core.bean.StartBean;
import com.leontsai.commonsdk.core.hub.RouterHub;

import com.leontsai.start.di.DaggerStartComponent;

import javax.inject.Inject;


@Route(path = RouterHub.START_MAINACTIVITY)
public class MainActivity extends AppCompatActivity {

    @Inject
    StartViewModelFactory startViewModelFactory;

    private static final String URL="https://restapi.amap.com/v3/weather/weatherInfo?key=ca3b0886701109bca675f5ba72fb29f0&city=330109";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity_main);


        StartBean startBean=new StartBean();
        startBean.setName(URL);

        DaggerStartComponent
                .builder()
                .appComponent(((IApp)getApplication()).getAppComponent())
                .startBean(startBean)
                .build()
                .inject(this);

        MainViewModel mainViewModel= ViewModelProviders.of(this,startViewModelFactory).get(MainViewModel.class);
        mainViewModel.net();

        findViewById(R.id.startApp).setOnClickListener(
                v -> {
//                    OkGo.get("https://restapi.amap.com/v3/weather/weatherInfo?key=ca3b0886701109bca675f5ba72fb29f0&city=330109")//
//                            .tag(this)//
//                            .cacheMode(CacheMode.NO_CACHE)//
//                            .cacheKey("no_cache")   //对于无缓存模式,该参数无效
//                            .cacheTime(5000)        //对于无缓存模式,该时间无效
//                            .execute(new AbsCallback<Object>() {
//                                @Override
//                                public void onSuccess(Response<Object> response) {
//
//                                }
//
//                                @Override
//                                public Object convertResponse(okhttp3.Response response) throws Throwable {
//                                    return null;
//                                }
//                            });

                    mainViewModel.net();
                }
        );



    }
}
