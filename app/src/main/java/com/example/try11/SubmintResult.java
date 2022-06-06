package com.example.try11;
/**
 *本类本质是访问某个地址的类，
 *其用途是以某些参数访问某个servlet，以将数据提交给servlet处理
 *也可访问某个网址，以将网页中的数据读取下来
 */
import java.io.*;
import java.net.*;
import java.util.*;
import android.os.AsyncTask;

public class  SubmintResult extends AsyncTask<String,Integer,String> {
    @Override
    protected String doInBackground(String... params) {
        String par = params[0];
        URL url = null;
        try {
            url = new URL(par);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String result = HttpUtil.doPost(url);
        return result;
    }


    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        //打印数据
        System.out.println(result);
    }

    public String requestInfo(String requestUrl){
        Scanner scanner = null;
        String result = "未获取到网页内容!";
        try {
            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.connect();
            InputStream inputStream = httpUrlConn.getInputStream();     // 获得返回的输入流
            scanner = new Scanner(inputStream).useDelimiter("\\A");
            result = scanner.hasNext() ? scanner.next() : "";
        }catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     *使用方法如下
     */
    /*public static void main(String[] args){
        SubmintResult sr = new SubmintResult();
        sr.execute("localhost/test/Servlet?num=1&user=kenn");	//访问某个网址以提交给servlet处理数据
        //String result = sr.requestInfo("https://www.baidu.com/");	//读取此网页，然后将网页内容读取下来
        //System.out.println(result);
    }*/

}
