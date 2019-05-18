package com.leontsai.start;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.gson.Gson;
import com.leontsai.commonsdk.base.IApp;
import com.leontsai.commonsdk.utils.LogUtil;
import com.leontsai.start.di.DaggerStartComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity_main);

        DaggerStartComponent.builder().appComponent(((IApp)getApplication()).getAppComponent()).build().inject(this);


        LogUtil.d("gson:"+gson);
    }
}
