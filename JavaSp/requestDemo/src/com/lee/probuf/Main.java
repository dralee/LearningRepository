package com.lee.probuf;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.Appinfo;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {

        TestRequest appinfo = new TestRequest();
        appinfo.authorizeLogin("abcdefg", "state", "asdfsd", "");

        System.out.println("xxxxxxx");
    }


    static class TestRequest {
        public void authorizeLogin(String code, String state, String lang, String country) {
            String host = "http://localhost:800/";//AppInfo.getHost();
            String strUrl = "User/Weixin/AppAuthorize";
            String strUrlRes = "User/Weixin/AppAuthorizeLogin?openId=";
            try {
                strUrl = host.lastIndexOf('/') == -1 ? String.format("%s/%s", host, strUrl) : String.format("%s%s", host, strUrl);
                URL url = new URL(strUrl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("content-Type","application/json");
                conn.setDoOutput(true);
                conn.setDoInput(true);
                /*
                JSONObject parameter = new JSONObject();
                parameter.put("code",code);
                parameter.put("state",state);
                parameter.put("lang", lang);
                parameter.put("country", country);*/

                String para = "{\n" +
                        "    \"code\": \"asdfdsf\",\n" +
                        "    \"state\": \"ZKCloudApp\",\n" +
                        "    \"lang\": \"\",\n" +
                        "    \"country\": \"\"\n" +
                        "}";

            /*PrintWriter printWriter = new PrintWriter(conn.getOutputStream());
            printWriter.write("code=" + code + "&state=" + state + "&lang=" + lang + "&country=" + country);
            printWriter.flush();
            printWriter.close();*/
                OutputStream outputStream = conn.getOutputStream();
                outputStream.write(para.toString().getBytes());
                outputStream.flush();
                outputStream.close();

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
                //ShowToastSub(res);
                /*JSONObject result = new JSONObject(res);
                if (result.getBoolean("success")) {
                    String openId = result.getString("openId");
                    strUrlRes = host.lastIndexOf('/') == -1 ? String.format("%s/%s%s", host, strUrlRes, openId) : String.format("%s%s%s", host, strUrlRes, openId);
                    //ShowToastSub(strUrlRes);z
                    LoadUrlSub(strUrlRes);*/
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        private void ShowToastSub(String msg) {
            System.out.println(msg);
        }
    }
}
