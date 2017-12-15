package com.lee.jackie.xgapidemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.XGPushManager;

public class MainActivity extends AppCompatActivity {
    private long userId = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 开启logcat输出，方便debug，发布时请关闭
        XGPushConfig.enableDebug(this, true);
        // 传递的参数为
        //ApplicationContext Context context = getApplicationContext();
        XGPushManager.registerPush(getApplicationContext(),String.valueOf(userId), new XGIOperateCallback() {
            @Override
            public void onSuccess(Object o, int i) {
                showTask("registerPush sucessfully.");
            }

            @Override
            public void onFail(Object o, int i, String s) {
                showTask("registerPush failed.");
            }
        });

        //XGPushManager.setTag(getApplicationContext(),"测试");

    }

    private void showTask(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
