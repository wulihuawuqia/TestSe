package api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 版权所有： 爱WiFi无线运营中心
 * 创建日期:2017年1月17日 下午2:17:45
 * 创建作者：许小满
 * 文件名称：RegexUtil1.java
 * 版本：  v1.0
 * 功能：正则匹配工具类
 * 修改记录：
 */
public class RegexUtil {

    /**
     * 正则匹配
     * @param str 待匹配字符串
     * @param pattern 正则表达式
     * @return true 成功、false 失败
     * @author 许小满  
     * @date 2017年1月17日 下午2:17:25
     */
    public static boolean match(String str, String pattern){
        return match(str, pattern, null);
    }
    
    /**
     * 正则匹配
     * @param str 待匹配字符串
     * @param pattern 正则表达式
     * @param flags flags
     * @return true 成功、false 失败
     * @author 许小满  
     * @date 2016年7月25日 下午12:13:16
     */
    public static boolean match(String str, String pattern, Integer flags){
        if(str == null){
            return false;
        }
        Pattern p = null;
        if(flags == null){
            p = Pattern.compile(pattern);
        }else {
            p = Pattern.compile(pattern, flags);
        }
        Matcher m = p.matcher(str);
        return m.matches();
    }
    
}
