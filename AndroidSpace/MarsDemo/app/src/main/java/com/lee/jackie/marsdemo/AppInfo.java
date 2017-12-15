package com.lee.jackie.marsdemo;

import com.tencent.mars.xlog.Log;
import com.tencent.mars.xlog.Xlog;

/**
 * Created by Jackie on 2017/7/13.
 */

public class AppInfo {
/*
    private MainActivity mainActivity;
    public AppInfo(MainActivity mainActivity){
        this.mainActivity=mainActivity;
    }

    // this is necessary, or may cash for SIGBUS
    final String cachePath = this.getFilesDir() + "/xlog";

    private void useXlog(){
        System.loadLibrary("stlport_shared");
        System.loadLibrary("marsxlog");

        // init xlog
        if(BuildConfig.DEBUG){
            Xlog.appenderOpen(Xlog.LEVEL_DEBUG, Xlog.AppednerModeAsync, cachePath, logPath,"MarsDemo");
            Xlog.setConsoleLogOpen(true);
        }else{
            Xlog.appenderOpen(Xlog.LEVEL_INFO,Xlog.AppednerModeAsync,cachePath,logPath,"MarsDemo");
            Xlog.setConsoleLogOpen(false);
        }
        Log.setLogImp(new Xlog());
    }*/
}
