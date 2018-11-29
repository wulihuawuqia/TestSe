/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年11月16日 下午2:50:05
* 创建作者：伍恰
* 文件名称：Http.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package api;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;


public class Http {
    public static void main(String[] args) throws Exception {
//      String url_pushTask = "http://134.96.159.10:8001/ESBWeb/servlets/33.1226.materialcontrastIssued.SynReq@1.0";
        String url_pushTask ="http://183.159.36.182:443/aistores/materialcontrast";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String appid="material";//分配给应用的唯一ID（由Ai连锁店平台提供）
        String appkey="123456";//分配给应用的加密串（由Ai连锁店平台提供）
        String timestamp=String.valueOf(System.currentTimeMillis()/1000);//服务器时间戳（秒）1419399913
        String access_token=getMd5Str(appid+"_"+appkey+"_"+timestamp);//MD5( appid _ appkey _ timestamp )此处为32位小写
        String contrastId="test11161434";//点检编号(即为点检信息的id)
        String contrastDate=String.valueOf(sdf.parse("2017-11-18 14:12:00").getTime()/1000);//点检时间，服务器时间戳（秒）
        String specimenImage = "iVBORw0KGgoAAAANSUhEUgAAACAAAAAgCAYAAABzenr0AAABZ0lEQVRYR+2Wz06EMBDGZ6C9rZETCTcfYfcBNPrkGn0AfQO9kXBhN2vgQEnNGEgIaWlnloiH5Qil36/f/OkgbPzgxvpwBfi/DlRVte/7/lgUxdcleVKW5V2aplme5x+ufZwOkLgx5t1ae9RaP/l+DoHRPl3XPSNippQ6uPZxAtR1nbVtSye/lUJMxQHghIh7l5veHBhceJFAzMWVUo+sEIzWSiA44qQTrAIOBFc8CoAWxUBIxKMBQhBScRaAD4Lej6VG2b6UcNF9YKm+p+EAgLO1FhDxRiLOdmBWHW8AsKN31tpvrfW9pGEFq8DlxhDz1+HktOSslHr4E4BpwtHJEX/PsJN2TJYDrmwndWOMqGOycmCp1GL6hC+xoxyIqXMpRBAgRvySu2MRgCMuhVi8jqUdjhMO70DSNM0nTTLSDjeHSJLkED2QjCOZVNwVDtZINl48mw2loWFzze/BMlxTbJXreG2gqwM/Nm2NMMiBlccAAAAASUVORK5CYII=";
        Map param = new HashMap();
        param.put("appid", appid);
        param.put("timestamp", timestamp);
        param.put("access_token", access_token);
        param.put("contrastId", contrastId);
        param.put("contrastDate", contrastDate);
        param.put("storesId", "[\"9-A1G9CUQ\",\"1-HM5V-29\"]");
        param.put("fileName", "test.png");
        param.put("specimenImage", specimenImage);
        String jsonStr=com.alibaba.fastjson.JSONObject.toJSONString(param);
        
        
        URL localURL = new URL(url_pushTask);
        URLConnection connection = localURL.openConnection();
        HttpURLConnection httpURLConnection = (HttpURLConnection)connection;   
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(jsonStr.length()));
        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;
        
        try {
            outputStream = httpURLConnection.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream);
            
            outputStreamWriter.write(jsonStr.toString());
            outputStreamWriter.flush();
            
            if (httpURLConnection.getResponseCode() >= 300) {
                throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
            }
            
            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");//new InputStreamReader(inputStream);之前的代码没有添加UTF-8，给其他系统测试的时候--可能会出现乱码的情况
            reader = new BufferedReader(inputStreamReader);
            
            while ((tempLine = reader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }
            
        } finally {
            
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
            
            if (outputStream != null) {
                outputStream.close();
            }
            
            if (reader != null) {
                reader.close();
            }
            
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            
            if (inputStream != null) {
                inputStream.close();
            }
            
        }
        System.out.println(resultBuffer.toString());
        //return resultBuffer.toString();
        
        
        
        
        
//      String info = null;
//      try
//      {
//      HttpClient httpclient = new HttpClient();
//      PostMethod post = new PostMethod(url_pushTask);
//      post.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");
//      post.getParams().setParameter("Content-Type", "application/x-www-form-urlencoded");
//      //post.setRequestBody(jsonStr);
//      //String j=com.alibaba.fastjson.JSONObject.toJSONString(paramBody);
////        post.setParameter("requestStr", jsonStr);
//      post.setParameter("appid", appid);
//      post.setParameter("timestamp", timestamp);
//      post.setParameter("access_token", access_token);
//      post.setParameter("contrastId", contrastId);
//      post.setParameter("contrastDate", contrastDate);
//      post.setParameter("storesId", "[\"9-A1G9CUQ\",\"1-HM5V-29\"]");
//      post.setParameter("fileName", "test.png");
//      post.setParameter("specimenImage", specimenImage);
//      post.getParameter("appid");
//      httpclient.executeMethod(post);
//      info = new String(post.getResponseBody(),"utf-8");
//      //System.out.println(info);
//      }
//      catch (Exception e) 
//      {
//      e.printStackTrace();
//      }
//      
//      
//      
//      System.out.println(info);
    }
    public static String getMd5Str(String str) {
        if (str == null){
            return StringUtils.EMPTY;
        }
        byte[] pb = null;
        try {
            pb = str.getBytes("utf-8");
        } catch (Exception e) {
        }
        return DigestUtils.md5DigestAsHex(pb);
    }
}
