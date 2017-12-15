package com.lee.jackie.andservicedemo;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.lee.jackie.andservicedemo.services.IStudentService;
import com.lee.jackie.andservicedemo.services.StudentService;

public class MainActivity extends AppCompatActivity {
    private IStudentService studentService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 开户查询名称的服务
        Intent service = new Intent(this, StudentService.class);
        bindService(service,new StudentConnection(), BIND_AUTO_CREATE);
        // 延迟2秒显示查询内容，不然开启服务也是需要时间的，如不延迟一段时间，student对象为null
        new Thread(){
            public void  run(){
                try{
                    Thread.sleep(2000);
                    Looper.prepare();
                    Toast.makeText(getApplicationContext(),studentService.getNameByNumber(1),Toast.LENGTH_LONG).show();
                    Looper.loop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    // 自定义服务连接connection
    public class StudentConnection implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            studentService = (IStudentService)service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    }
}
