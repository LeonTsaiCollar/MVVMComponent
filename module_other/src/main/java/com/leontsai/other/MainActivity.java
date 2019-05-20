package com.leontsai.other;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.leontsai.commonsdk.core.hub.RouterHub;


@Route(path = RouterHub.OTHER_MAINACTIVITY)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_activity_main);
        findViewById(R.id.other).setOnClickListener(
                v -> {
                    ARouter.getInstance().build(RouterHub.START_MAINACTIVITY).navigation();
                }
        );
    }
}
