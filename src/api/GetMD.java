/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年12月4日 下午5:08:16
* 创建作者：伍恰
* 文件名称：Md5.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package api;

import java.security.MessageDigest;

public class GetMD {
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
    
    public static void main(String[] args) {
		System.out.println(MD5("awifi@123"));
	}
}
