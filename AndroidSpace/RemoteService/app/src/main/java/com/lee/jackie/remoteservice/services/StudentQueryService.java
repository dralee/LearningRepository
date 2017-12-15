package com.lee.jackie.remoteservice.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

/**
 * Created by Jackie on 2017/7/19.
 */

public class StudentQueryService extends Service{

    public static String[] nameArr = {"张飞","赵云","关羽"};
    private IBinder binder = new StudentQueryBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    // 服务中心定义的访问方法
    private String query(int number) {
        if(number > 0 && number < 4)
            return nameArr[number-1];
        return null;
    }

    // 自定义Binder对象
    private final class StudentQueryBinder extends StudentQuery.Stub{
        public String queryStudent(int number) throws RemoteException{
            return query(number);
        }
    }
}
