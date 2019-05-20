package com.leontsai.mvvmcomponent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.alibaba.android.arouter.launcher.ARouter;
import com.leontsai.commonsdk.core.hub.RouterHub;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.shell).setOnClickListener(
                v->{
                    ARouter.getInstance().build(RouterHub.START_MAINACTIVITY).navigation();
                }
        );
    }
}
