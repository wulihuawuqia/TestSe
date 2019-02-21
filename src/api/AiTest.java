/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年10月31日 上午9:42:19
* 创建作者：伍恰
* 文件名称：AiTest.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package api;

import java.security.MessageDigest;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.util.DigestUtils;


public class AiTest {
    
    @Test
    public void getTimestamp() {
        Long timestamp = System.currentTimeMillis()/1000;
        System.out.println(timestamp);
    }
    
    @Test 
    public void getToken() {
        String appid = "material";
        String appkey = "YVWNM8crA5F1";
        Long timestamp = System.currentTimeMillis()/1000;
        String token = getMd5Str(appid+"_"+appkey+"_"+timestamp);
        System.out.println(timestamp);
        getBeginTime();
        System.out.println(token);
        System.out.println(MD5(appid+"_"+appkey+"_"+timestamp));
    }
    
    @Test
    public void getBeginTime() {
        Long timestamp = System.currentTimeMillis()/1000;
        System.out.println("beginTime:"+(timestamp+30));
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
    
    public final static String MD5(String s) {  
        char hexDigits[]={'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};         
        try {  
            byte[] btInput = s.getBytes("utf-8");  
            // 获得MD5摘要算法的 MessageDigest 对象  
            MessageDigest mdInst = MessageDigest.getInstance("MD5");  
            // 使用指定的字节更新摘要  
            //mdInst.update(btInput);  
            // 获得密文  
            byte[] md = mdInst.digest(btInput);  
            // 把密文转换成十六进制的字符串形式  
            char chars[] = new char[32];
            for (int i = 0; i < chars.length; i = i + 2) {
                byte b = md[i / 2];
                chars[i] = hexDigits[(b >>> 0x4) & 0xf];
                chars[i + 1] = hexDigits[b & 0xf];
            }
            return new String(chars);  
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
    }  
}
