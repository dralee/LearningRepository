package com.lee.jackie.remoteservice.client;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.lee.jackie.remoteservice.services.StudentQuery;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    // 定义控件
    private EditText numberText;
    private TextView resultView;
    private StudentQuery studentQuery;

    // 定义一个连接
    private StudentConnection connection = new StudentConnection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberText = (EditText)findViewById(R.id.number);
        resultView = (TextView)findViewById(R.id.result);
        // 这里开启一个service使用隐式意图action的名称必须与remoteService中AndroidMainfest.xml中定义的服务的action的name一致
        //Intent service = new Intent("com.lee.jackie.student.query"); // 要将隐式变为显式调用
        Intent intent = new Intent();
        intent.setAction("com.lee.jackie.student.query");
        final Intent eintent = new Intent(createExplicitFromImplicitIntent(this,intent));
        bindService(eintent,connection,BIND_AUTO_CREATE);
    }

    // 给按钮定义点击事件
    public void queyStudent(View v){
        String number = numberText.getText().toString();
        int num = Integer.parseInt(number);
        try {
            String res = studentQuery.queryStudent(num);
            resultView.setText(res);
            Toast.makeText(getApplicationContext(),res,Toast.LENGTH_LONG).show();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        unbindService(connection);
        super.onDestroy();
    }

    // 自定义StudentConnection实现了ServiceConnection
    private final class StudentConnection implements ServiceConnection{

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            // 这里就用到了Stub类中的asInterface方法，将IBinder对象转换成接口
            studentQuery = StudentQuery.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            studentQuery = null;
        }
    }

    /***
     * Android L (lollipop, API 21) introduced a new problem when trying to invoke implicit intent,
     * "java.lang.IllegalArgumentException: Service Intent must be explicit"
     *
     * If you are using an implicit intent, and know only 1 target would answer this intent,
     * This method will help you turn the implicit intent into the explicit form.
     *
     * Inspired from SO answer: http://stackoverflow.com/a/26318757/1446466
     * @param context
     * @param implicitIntent - The original implicit intent
     * @return Explicit Intent created from the implicit original intent
     */
    public static Intent createExplicitFromImplicitIntent(Context context, Intent implicitIntent) {
        // Retrieve all services that can match the given intent
        PackageManager pm = context.getPackageManager();
        List<ResolveInfo> resolveInfo = pm.queryIntentServices(implicitIntent, 0);

        // Make sure only one match was found
        if (resolveInfo == null || resolveInfo.size() != 1) {
            return null;
        }

        // Get component info and create ComponentName
        ResolveInfo serviceInfo = resolveInfo.get(0);
        String packageName = serviceInfo.serviceInfo.packageName;
        String className = serviceInfo.serviceInfo.name;
        ComponentName component = new ComponentName(packageName, className);

        // Create a new intent. Use the old one for extras and such reuse
        Intent explicitIntent = new Intent(implicitIntent);

        // Set the component to be explicit
        explicitIntent.setComponent(component);

        return explicitIntent;
    }
}
