/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年11月7日 上午10:20:50
* 创建作者：伍恰
* 文件名称：DoubleTest.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package api;

import org.apache.commons.lang3.StringUtils;

public class DoubleTest {
    public static void main(String[] args) {
        double a = 6.279069767441861;
        Object aa= 6.279069767441861;
        System.out.println(toDouble(aa));
        System.out.println(a);
    }
    
    public static Double toDouble(Object obj){
        if (obj == null) {
            return null; 
        } else if (obj instanceof Long || obj instanceof Integer || obj instanceof String || obj instanceof Float || obj instanceof Double) {
            String str = obj.toString();
            if(StringUtils.isBlank(str)){
                return null; 
            }
            return Double.valueOf(str).doubleValue();
        } else {
            return null;
        }
    }
}
