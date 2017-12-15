package com.lee.jackie.andservicedemo.services;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by Jackie on 2017/7/19.
 */

public class StudentService extends Service {
    public static String[] nameArr = {"张飞","赵云","关羽"};

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new StudentBinder();
    }

    private String getNameByNo(int no) {
        if(no > 0 && no < 4)
            return nameArr[no];
        return null;
    }

    // 自定义Binder对象
    private class StudentBinder extends Binder implements IStudentService{

        @Override
        public String getNameByNumber(int no) {
            return getNameByNo(no);
        }
    }
}
