package org.levensoft.zkcloudapp.wxapi;

import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Jackie on 2017/6/5.
 */

public class AppInfo {
    public static  String url = "http://139.199.59.138/User/weixin/GetInvoiceInfo";
    public static String appId = "wx1354e062b7682ed8";
    private static WXEntryActivity mainActivity;

    public static void init(WXEntryActivity activity){
        mainActivity = activity;
    }

    public static void showToast(String msg){
        Toast.makeText(mainActivity, msg, Toast.LENGTH_LONG).show();
    }

    public static String getUrl(String strUrl) {
        try {
            URL url = new URL(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //conn.setRequestMethod("POST");
            //conn.setDoOutput(true);
            //conn.setDoInput(true);
            /*PrintWriter printWriter = new PrintWriter(conn.getOutputStream());
            printWriter.write("code=" + code + "&state=" + state + "&lang=" + lang + "&country=" + country);
            printWriter.flush();
            printWriter.close();*/

            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            byte[] buffer = new byte[1024];
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
                bos.flush();
            }
            bos.close();
            String res = bos.toString("utf-8");
            return res;
        } catch (ProtocolException e) {
            showToast(e.toString());
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            showToast(e.toString());
        } catch (IOException e) {
            showToast(e.toString());
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] getUrlBytes(String strUrl) {
        try {
            URL url = new URL(strUrl);
            AppInfo.showToast(strUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-Type","application/json");
            //conn.setDoOutput(true);
            //conn.setDoInput(true);
            /*PrintWriter printWriter = new PrintWriter(conn.getOutputStream());
            printWriter.write("code=" + code + "&state=" + state + "&lang=" + lang + "&country=" + country);
            printWriter.flush();
            printWriter.close();*/

            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            int len;
            byte[] buffer = new byte[1024];
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
                bos.flush();
            }
            byte[] res = bos.toByteArray();
            bos.close();
            //String res = bos.toString("utf-8");
            return res;
        } catch (ProtocolException e) {
            showToast(e.toString());
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            showToast(e.toString());
        } catch (IOException e) {
            showToast(e.toString());
            e.printStackTrace();
        }
        return null;
    }
}
