package com.ljl.jackie.httpreqdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnGet,btnPostKeyValue,btnPostXml,btnPostJson;
    // NETWORK_GET表示发送GET请求
    public static  final String NETWORK_GET = "NETWORK_GET";
    // NETWORK_POST_KEY_VALUE表示用POST发送键值对数据
    public static  final String NETWORK_POST_KEY_VALUE = "NETWORK_POST_KEY_VALUE";
    // NETWORK_POST_XML表示用POST发送XML数据
    public static  final String NETWORK_POST_XML = "NETWORK_POST_XML";
    // NETWORK_POST_JSON表示用POST发送JSON数据
    public static  final String NETWORK_POST_JSON = "NETWORK_POST_JSON";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnGet = (Button)findViewById(R.id.btnGet);
        btnPostKeyValue = (Button)findViewById(R.id.btnPost);
        btnPostXml = (Button)findViewById(R.id.btnPostXml);
        btnPostJson = (Button)findViewById(R.id.btnPostJson);

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postIntent(NETWORK_GET);
            }
        });

        btnPostKeyValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postIntent(NETWORK_POST_KEY_VALUE);
            }
        });

        btnPostXml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postIntent(NETWORK_POST_XML);
            }
        });

        btnPostJson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                postIntent(NETWORK_POST_JSON);
            }
        });
    }

    private void postIntent(String action){
        Intent intent = new Intent(MainActivity.this,NetworkActivity.class);
        intent.putExtra("action",action);
        startActivity(intent);
    }
}
