package com.tustcs.matrix.utils;

import com.tustcs.matrix.config.Config;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author L.key.
 * @Date 2017/6/14 16:08
 */
public class URLUtils {

    /**
     * 依据params POST请求URL 返回响应页面
     *
     * @param urlPath    请求路径
     * @param params     请求参数
     * @param cookie     cookie值
     * @param needCookie 是否需要cookie，1是，非1否
     * @return html的字符串
     * @throws IOException 异常抛出
     */
    public static String accessUrl(String urlPath, String params, String cookie, int needCookie) throws IOException {
        URL url = new URL(urlPath);

        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        // 设置是否向httpUrlConnection输出，因为这个是post请求，参数要放在
        // http正文内，因此需要设为true, 默认情况下是false;
        httpURLConnection.setDoOutput(true);

        // 设置是否从httpUrlConnection读入，默认情况下是true;
        httpURLConnection.setDoInput(true);

        // 设置一个指定的超时值（以毫秒为单位）
        httpURLConnection.setConnectTimeout(30000);
        // 将读超时设置为指定的超时，以毫秒为单位。
        httpURLConnection.setReadTimeout(30000);

        // Post 请求不能使用缓存
        httpURLConnection.setUseCaches(false);

        // 设定请求的方法为"POST"，默认是GET
        httpURLConnection.setRequestMethod("POST");

        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        httpURLConnection.setRequestProperty("Connection", "Keep-Alive");// 维持长连接

        httpURLConnection.setRequestProperty("Charset", "UTF-8");

        httpURLConnection.setRequestProperty("Cookie", cookie);

        //不重定向
        httpURLConnection.setInstanceFollowRedirects(false);

        // 连接，从上述url.openConnection()至此的配置必须要在connect之前完成，
        //httpURLConnection.connect();

        // 此处getOutputStream会隐含的进行connect(即：如同调用上面的connect()方法，
        // 所以在开发中不调用上述的connect()也可以
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        //把参数写入流
        dataOutputStream.writeBytes(params);
        dataOutputStream.flush();
        dataOutputStream.close();

        //如果返回的状态码不是200 表明发送请求失败
        if (httpURLConnection.getResponseCode() != HttpURLConnection.HTTP_OK) {
            return String.valueOf(httpURLConnection.getResponseCode());
        }
        //发送请求和返回响应流
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), Config.CHARSET));
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        bufferedReader.close();
        return needCookie == 1 ? httpURLConnection.getHeaderField("Set-Cookie") : stringBuilder.toString();
    }

    /**
     * 返回html字符串中的用戶信息
     * @param html 转化的html字符转
     * @return 存储信息的list集合
     * @throws IOException 异常抛出
     */
    public static Map<String,Object> resolveHtml(String html) throws IOException {
        Document doc = Jsoup.parse(html);
        Map<String,Object> userMap = new HashMap<String, Object>();
        Element div = doc.getElementById(Config.NAME_DIV_ID);
        //姓名在查询到的标签列表中的第一个索引为0
        Element name = div.select(Config.NAME_TAGNAME).get(0);
        userMap.put("nick",name.text().substring(name.text().indexOf("：")+1,name.text().length()).trim());
        //身份信息所属标签
        Element divs = doc.select(Config.MSG_DIV_CLASS).get(0);
        Elements msgTags = divs.children();
        String message = msgTags.text();
        userMap.put("userId",message.substring(message.indexOf("号")+2,message.indexOf("身")).trim());
        userMap.put("level",message.substring(message.indexOf("份")+2,message.indexOf("院")).trim());
        userMap.put("school",message.substring(message.indexOf("系")+2,message.length()).trim());
        return userMap;
    }


    public static void main(String[] args) {
        try {
            String cookie = accessUrl("http://urp.tust.edu.cn/userPasswordValidate.portal", "Login.Token1=14101308&Login.Token2=lgd1498704182LGD", "", 1);
            String html = accessUrl("http://urp.tust.edu.cn/index.portal", "", cookie, 0);
            Map<String,Object> userMsg=resolveHtml(html);
            System.out.println(userMsg.get("school"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
