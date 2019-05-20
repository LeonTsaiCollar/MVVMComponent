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
import okhttp3.*;

import javax.inject.Inject;
import java.io.IOException;


@Route(path = RouterHub.START_MAINACTIVITY)
public class MainActivity extends AppCompatActivity {

    @Inject
    OkHttpClient okHttpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity_main);

        DaggerStartComponent.builder().appComponent(((IApp) getApplication()).getAppComponent()).build().inject(this);


        findViewById(R.id.startApp).setOnClickListener(
                v -> {
//                    Request request = new Request.Builder()
//                            .url("https://restapi.amap.com/v3/weather/weatherInfo?key=ca3b0886701109bca675f5ba72fb29f0&city=330109").build();
//
//                    okHttpClient.newCall(request).enqueue(new Callback() {
//                        @Override
//                        public void onFailure(Call call, IOException e) {
//                            Log.d("cyl", e.getMessage());
//                        }
//
//                        @Override
//                        public void onResponse(Call call, Response response) throws IOException {
//                            String s = new String(response.body().bytes());
//                            Log.d("cyl", s);
//                        }
//                    });
                    ARouter.getInstance().build(RouterHub.HOME_MAINACTIVITY).navigation();

                }
        );


    }
}
