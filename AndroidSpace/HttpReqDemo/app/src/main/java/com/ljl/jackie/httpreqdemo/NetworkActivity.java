package com.ljl.jackie.httpreqdemo;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import  java.util.Map;

public class NetworkActivity extends AppCompatActivity {

    private  NetworkAsyncTask networkAsyncTask = new NetworkAsyncTask();

    private TextView tvUrl, tvRequestHeader,tvRequestBody,tvResponseHeader,tvResponseBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        tvUrl = (TextView)findViewById(R.id.tvUrl);
        tvRequestHeader = (TextView)findViewById(R.id.tvRequestHeader);
        tvRequestBody = (TextView)findViewById(R.id.tvRequestBody);
        tvResponseHeader = (TextView)findViewById(R.id.tvResponseHeader);
        tvResponseBody = (TextView)findViewById(R.id.tvResponseBody);

        Intent intent = getIntent();
        if(intent != null && intent.getExtras() != null){
            String networkAction = intent.getStringExtra("action");
            networkAsyncTask.execute(networkAction);
        }

    }

    // 用于进行网络请求的AsyncTask
    class  NetworkAsyncTask extends AsyncTask<String, Integer, Map<String, Object>>{
        // NETWORK_GET表示发送GET请求
        public static  final String NETWORK_GET = "NETWORK_GET";
        // NETWORK_POST_KEY_VALUE表示用POST发送键值对数据
        public static  final String NETWORK_POST_KEY_VALUE = "NETWORK_POST_KEY_VALUE";
        // NETWORK_POST_XML表示用POST发送XML数据
        public static  final String NETWORK_POST_XML = "NETWORK_POST_XML";
        // NETWORK_POST_JSON表示用POST发送JSON数据
        public static  final String NETWORK_POST_JSON = "NETWORK_POST_JSON";

        private final static String SERVER_URL = "http://192.168.1.119:8090/HttpServer";
        private final static String KEY_URL = "url";
        private final static String KEY_Action = "action";
        private final static String KEY_RequestHeader = "requestHeader";
        private final static String KEY_RequestBody = "requestBody";
        private final static String KEY_ResponseHeader = "responseHeader";
        private final static String KEY_ResponseBody = "responseBody";

        @Override
        protected Map<String, Object> doInBackground(String... params) {
            Map<String,Object> result = new HashMap<>();
            URL url = null; // 请求的URL地址
            HttpURLConnection conn = null;
            String requestHeader = null; // 请求头
            byte[] requestBody = null; // 请求体
            String responseHeader = null; // 响应头
            byte[] responseBody = null; // 响应体
            String action = params[0]; // http请求的操作类型

            try{
                if(NETWORK_GET.equals(action)){
                    // 发送GET请求
                    url = new URL(SERVER_URL+"?name=李建龙&age=28");
                    conn = (HttpURLConnection)url.openConnection();
                    // HttpURLConnection默认就是用GET发送请求
                    conn.setRequestMethod("GET");
                    // HttpURLConnection默认也支持从服务器读取结果流
                    conn.setDoInput(true);
                    // 用setRequestProperty设置一个自定义请求头：action，用于后端判断
                    conn.setRequestProperty("action",NETWORK_GET);
                    // 禁用网络缓存
                    conn.setUseCaches(false);
                    // 获取请求头
                    requestHeader = getRequestHeader(conn);
                    // 在各种参数配置完成后，通过调用connect方法建立 TCP连接，但未真正获取数据
                    // conn.connect()不必显示调用，当调用conn.getInputStream()时内部也会自动调用connect方法
                    conn.connect();
                    // 调用getInputStream方法后，服务端才会收到请求，并阻塞式接收服务端返回数据
                    InputStream is = conn.getInputStream();
                    // 将InputStream转换成byte数组，getByteByInputStream会关闭输入流
                    responseBody = getBytesByInputStream(is);
                    // 获取响应头
                    responseHeader = getResponseHeader(conn);
                }else if(NETWORK_POST_KEY_VALUE.equals(action)){
                    // 用POST发送键值对数据
                    url = new URL(SERVER_URL);
                    conn = (HttpURLConnection)url.openConnection();
                    conn.setRequestMethod("POST");;
                    // 调用conn.setDoOutput()方法以显式开启请求体
                    conn.setDoOutput(true);
                    conn.setRequestProperty("action",NETWORK_POST_KEY_VALUE);
                    conn.setRequestProperty("Content-Type","application/json");
                    requestHeader = getRequestHeader(conn);
                    OutputStream os = conn.getOutputStream();
                    requestBody = new String("name=李建龙&age=28").getBytes();
                    // 将请求体写入conn输出流中
                    os.write(requestBody);
                    // 记得调用输出流的flush方法
                    os.flush();
                    os.close();
                    // 当调用getInputStream方法才真正将请求体数据上传至服务器
                    InputStream is = conn.getInputStream();
                    responseBody = getBytesByInputStream(is);
                    responseHeader = getResponseHeader(conn);
                }else if(NETWORK_POST_XML.equals(action)){
                    // 用POST发送XML数据
                    url = new URL(SERVER_URL);
                    conn = (HttpURLConnection)url.openConnection();
                    conn.setRequestMethod("POST");
                    // 显式开启请求体
                    conn.setDoOutput(true);
                    conn.setRequestProperty("action", NETWORK_POST_XML);
                    conn.setRequestProperty("Content-Type","application/json");
                    requestHeader = getRequestHeader(conn);
                    OutputStream os = conn.getOutputStream();
                    requestBody = getBytesFromAssets("person.xml");
                    // 将请求体写入到conn输出流中
                    os.write(requestBody);
                    os.flush();
                    os.close();
                    InputStream is = conn.getInputStream();
                    responseBody = getBytesByInputStream(is);
                    responseHeader = getResponseHeader(conn);
                }else if(NETWORK_POST_JSON.equals(action)){
                    // 用POST发送JSON数据
                    url = new URL(SERVER_URL);
                    conn = (HttpURLConnection)url.openConnection();
                    conn.setRequestMethod("POST");
                    conn.setDoOutput(true);
                    conn.setRequestProperty("action",NETWORK_POST_JSON);
                    conn.setRequestProperty("Content-Type","application/json");
                    requestHeader = getRequestHeader(conn);
                    OutputStream os = conn.getOutputStream();
                    requestBody = getBytesFromAssets("person.json");
                    os.write(requestBody);
                    os.flush();
                    os.close();
                    InputStream is = conn.getInputStream();
                    responseBody = getBytesByInputStream(is);
                    responseHeader = getResponseHeader(conn);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                // 最后将conn断开连接
                if(conn != null){
                    conn.disconnect();
                }
            }

            result.put(KEY_URL,url.toString());
            result.put(KEY_Action,action);
            result.put(KEY_RequestHeader,requestHeader);
            result.put(KEY_RequestBody,requestBody);
            result.put(KEY_ResponseHeader,responseHeader);
            result.put(KEY_ResponseBody,responseBody);

            return result;
        }

        @Override
        protected void onPostExecute(Map<String, Object> result) {
            super.onPostExecute(result);
            String url = (String)result.get(KEY_URL); // 请求URL地址
            String action = (String)result.get(KEY_Action); // 请求操作类型
            String requestHeader = (String)result.get(KEY_RequestHeader); // 请求头
            byte[] requestBody = (byte[]) result.get(KEY_RequestBody); // 请求体
            String responseHeader = (String)result.get(KEY_ResponseHeader); // 响应头
            byte[] responseBody = (byte[])result.get(KEY_ResponseBody); // 响应体
            
            // 更新tvUrl,显示url
            tvUrl.setText(url);
            // 更新tvRequestHeader，显示请求头
            if(requestHeader != null){
                tvRequestHeader.setText(requestHeader);
            }
            // 显示请求体
            if(requestBody != null){
                try{
                    String request = new String(requestBody, "UTF-8");
                    tvRequestBody.setText(request);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            // 显示响应头
            if(responseHeader != null){
                tvResponseHeader.setText(responseHeader);
            }
            // 显示响应体
            if(responseBody != null){
                String response = "";
                switch (action){
                    case NETWORK_GET:
                    case NETWORK_POST_KEY_VALUE:
                        response = getStringByBytes(responseBody); break;
                    case NETWORK_POST_XML:
                        response = parseXmlResultByBytes(responseBody); break;
                    case NETWORK_POST_JSON:
                        response = parseJsonResultByBytes(responseBody); break;
                }
                tvResponseBody.setText(response);
            }
        }

        // json字节数组进行解析
        private String parseJsonResultByBytes(byte[] bytes) {
            String jsonString = getStringByBytes(bytes);
            List<Person> persons = JsonParser.parse(jsonString);
            StringBuffer sb = new StringBuffer();
            for(Person person : persons){
                sb.append(person.toString()).append("\n");
            }
            return sb.toString();
        }

        // 将xml字节数组进行解析
        private String parseXmlResultByBytes(byte[] bytes) {
            InputStream is = new ByteArrayInputStream(bytes);
            StringBuffer sb = new StringBuffer();
            List<Person> persons = XmlParser.parse(is);
            for(Person person : persons){
                sb.append(person.toString()).append("\n");
            }
            return sb.toString();
        }

        // 据字节数组构建UTF-8字符串
        private String getStringByBytes(byte[] bytes) {
            String str = "";
            try{
                str = new String(bytes, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            return  str;
        }

        // 从asserts目录读取文件字节数组
        private byte[] getBytesFromAssets(String fileName) {
            byte[] bytes = null;
            AssetManager assertManager = getAssets();
            InputStream is = null;
            try{
                is = assertManager.open(fileName);
                bytes = getBytesByInputStream(is);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return bytes;
        }

        // 获取响应头
        private String getResponseHeader(HttpURLConnection conn) {
            Map<String,List<String>> responseHeaderMap = conn.getHeaderFields();
            int size = responseHeaderMap.size();
            StringBuffer sbResponseHeader = new StringBuffer();
            for (int i = 0; i <size;++i){
                String responseHeaderKey = conn.getHeaderFieldKey(i);
                String responseHeaderValue = conn.getHeaderField(i);
                sbResponseHeader.append(responseHeaderKey).append(":").append(responseHeaderValue).append("\n");
            }
            return sbResponseHeader.toString();
        }

        // 读取响应体，转换为byte数组，关闭InputStream
        private byte[] getBytesByInputStream(InputStream is) {
            byte[] bytes = null;
            BufferedInputStream bis = new BufferedInputStream(is);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            BufferedOutputStream bos = new BufferedOutputStream(baos);
            byte[] buffer = new byte[1024 * 8];
            int length = 0;
            try{
                while ((length = bis.read(buffer)) > 0){
                    bos.write(buffer,0,length);
                }
                bos.flush();
                bytes = baos.toByteArray();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try{
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return  bytes;
        }

        // 读取请求头
        private String getRequestHeader(HttpURLConnection conn) {
            Map<String,List<String>> requestHeaderMap = conn.getRequestProperties();
            Iterator<String> requestHeaderIterator = requestHeaderMap.keySet().iterator();
            StringBuffer sbRequestHeader = new StringBuffer();
            while (requestHeaderIterator.hasNext()){
                String requestHeaderKey = requestHeaderIterator.next();
                String requestHeaderValue = conn.getRequestProperty(requestHeaderKey);
                sbRequestHeader.append(requestHeaderKey).append(":").append(requestHeaderValue).append("\n");
            }
            return  sbRequestHeader.toString();
        }
    }
}
