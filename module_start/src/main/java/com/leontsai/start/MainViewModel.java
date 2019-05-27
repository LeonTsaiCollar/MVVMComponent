package com.leontsai.start;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.leontsai.commonsdk.core.bean.StartBean;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.cache.CacheMode;
import com.lzy.okgo.callback.AbsCallback;
import com.lzy.okgo.model.Response;

import javax.inject.Inject;

public class MainViewModel extends ViewModel {
    private MutableLiveData<StartBean> startBeanLiveData = new MutableLiveData<>();


    public MutableLiveData<StartBean> getStartBeanLiveData() {
        return startBeanLiveData;
    }

    @Inject
    public MainViewModel(StartBean startBean) {
        startBeanLiveData.setValue(startBean);
    }

    public void net() {
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
}
