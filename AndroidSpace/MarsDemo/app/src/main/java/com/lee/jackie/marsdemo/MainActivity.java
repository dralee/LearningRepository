package com.lee.jackie.marsdemo;

import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.tencent.mars.Mars;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.sdt.SdtLogic;
import com.tencent.mars.stn.StnLogic;
import com.tencent.mars.xlog.Log;
import com.tencent.mars.xlog.Xlog;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initSTN();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //useXlog();

    }

    final String SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath();
    final String logPath = SDCARD + "/marsdemo/log";
    final String filePath = SDCARD + "marsdemo/file";

    @Override
    public void finish() {
        super.finish();
        //Log.appenderClose();
    }

    private void useXlog(){

        // this is necessary, or may cash for SIGBUS
        final String cachePath = this.getFilesDir() + "/xlog";

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
    }

    private void initSTN(){
        AppLogic.ICallBack stub = new AppLogic.ICallBack() {
            @Override
            public String getAppFilePath() {
                return filePath;
            }

            @Override
            public AppLogic.AccountInfo getAccountInfo() {
                return new AppLogic.AccountInfo(1,"jackie");
            }

            @Override
            public int getClientVersion() {
                return 0;
            }

            @Override
            public AppLogic.DeviceInfo getDeviceType() {
                return new AppLogic.DeviceInfo("android phone","mobile");
            }
        };

        // set callback
        AppLogic.setCallBack(stub);
        StnLogic.setCallBack(new StnLogic.ICallBack() {
            @Override
            public boolean makesureAuthed() {
                return false;
            }

            @Override
            public String[] onNewDns(String host) {
                return new String[0];
            }

            @Override
            public void onPush(int cmdid, byte[] data) {

            }

            @Override
            public boolean req2Buf(int taskID, Object userContext, ByteArrayOutputStream reqBuffer, int[] errCode, int channelSelect) {
                return false;
            }

            @Override
            public int buf2Resp(int taskID, Object userContext, byte[] respBuffer, int[] errCode, int channelSelect) {
                return 0;
            }

            @Override
            public int onTaskEnd(int taskID, Object userContext, int errType, int errCode) {
                return 0;
            }

            @Override
            public void trafficData(int send, int recv) {

            }

            @Override
            public void reportConnectInfo(int status, int longlinkstatus) {

            }

            @Override
            public int getLongLinkIdentifyCheckBuffer(ByteArrayOutputStream identifyReqBuf, ByteArrayOutputStream hashCodeBuffer, int[] reqRespCmdID) {
                return 0;
            }

            @Override
            public boolean onLongLinkIdentifyResp(byte[] buffer, byte[] hashCodeBuffer) {
                return false;
            }

            @Override
            public void requestDoSync() {

            }

            @Override
            public String[] requestNetCheckShortLinkHosts() {
                return new String[0];
            }

            @Override
            public boolean isLogoned() {
                return false;
            }

            @Override
            public void reportTaskProfile(String taskString) {

            }
        });
        SdtLogic.setCallBack(new SdtLogic.ICallBack() {
            @Override
            public void reportSignalDetectResults(String resultsJson) {

            }
        });

        // Initialize the Mars PlatformComm
        Mars.init(getApplicationContext(),new Handler(Looper.getMainLooper()));

        // Initialize the Mars
        StnLogic.setLonglinkSvrAddr("http://localhost",new int[]{8080});
    }
}
