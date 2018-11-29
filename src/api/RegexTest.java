/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月16日 上午11:01:46
* 创建作者：伍恰
* 文件名称：RegexTest.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package api;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegexTest {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("^(1[0-9]{10})?$");
        Matcher m = p.matcher("17788583288");
        System.out.println(m.matches());
    }
    
    @Test
    public void test1(){
        System.out.println(RegexUtil.match("1","[0-1]"));
    }
    @Test
    public void test2(){
        System.out.println(RegexUtil.match("a1a","^[a-zA-Z0-9]{1,20}$"));
    }
    @Test 
    public void test3(){
        System.out.println(RegexUtil.match("17788583288","^(1[0-9]{10})?$"));
    }
    @Test
    public void test4(){
        String m = "([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?";
        System.out.println(RegexUtil.match("www.51awifi.com", m));
    }
    @Test
    public void test5(){
        String m = "(([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?)";
        String rules = "{'required':true, 'regex':'"+m+"'}";
        String aa = "{\"required\":true, \"regex\":\"([\\\\w-]+\\\\.)+[\\\\w-]+(/[\\\\w-./?%&=]*)?\"}";
        System.out.println(aa);
        Map<String,Object> ruleMap = JsonUtil.fromJson(aa, LinkedHashMap.class);
        System.out.println(JsonUtil.toJson(ruleMap));
    }
    @Test
    public void test6(){
        String regex = "(V|v)[0-z]{1,9}.[0-z]{1,9}.[0-z]{1,9}";
        String str = "Vz.A1.22";
        System.out.println(RegexUtil.match(str,regex));
        //return match(regex, "V".concat(str));
    }
    @Test
    public void test7() {
        String regex = "0|1";
        String str = "2";
        System.out.println(RegexUtil.match(str,regex));
    }
    @Test
    public void test8() {
        String regex = "(V|v)[0-z]{1,9}\\.[0-z]{1,9}\\.[0-z]{1,9}";
        String str = "vz.A1.22";
        String aa="V".concat(str);
        System.out.println(aa);
        System.out.println(RegexUtil.match(str,regex));
        System.out.println(match(regex,str));
    }
    @Test
    public void test9() {
        String str = "testContent中";
        String regex="^[a-zA-Z0-9\u4E00-\u9FA5]{0,100}+$";
        System.out.println(RegexUtil.match(str,regex));
        System.out.println(match(regex,str));
    }
    @Test
    public void test10() {
        String str = "123aA之后-_";
        String regex="^[0-9a-zA-Z\u4e00-\u9fa5_-]{0,100}$";
        System.out.println(RegexUtil.match(str,regex));
        System.out.println(match(regex,str));
    }
    
    @Test
    public void test11() {
        String str = "65536";
        String regex= "^[0-9]|[1-9]\\d{1,3}|[1-5]\\d{4}|6[0-5]{2}[0-3][0-5]$";
        System.out.println(RegexUtil.match(str,regex));
        System.out.println(match(regex,str));
    }


    
    /**
     * @Title:match
     * @param regex regex
     * @param str str
     * @return boolean
     */
    private static boolean match(String regex, String str){
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }
    @Test
    public void test12(){
        String m = "(([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?)";
        String rules = "{'required':true, 'regex':'"+m+"'}";
        String aa = "{\"required\":true, \"regex\":\"(-|\\\\+)?(90\\\\.0{0,6}|(\\\\d|[1-8]\\\\d)\\\\.\\\\d{0,6})\"}";
        System.out.println(aa);
        Map<String,Object> ruleMap = JsonUtil.fromJson(aa, LinkedHashMap.class);
        System.out.println(JsonUtil.toJson(ruleMap));
    }
    
    @Test
    public void test13() {
        String regex = "^(\\-|\\+)?(90(.0{0,2})?|[1-8]?[0-9](.[0-9]{0,2})?)$";
        Double aa = 1D;
        System.out.println(aa.toString());
        System.out.println(RegexUtil.match(aa.toString(),regex));
        aa = +90D;
        System.out.println(aa.toString());
        System.out.println(RegexUtil.match(aa.toString(),regex));
        aa = -90D;
        System.out.println(aa.toString());
        System.out.println(RegexUtil.match(aa.toString(),regex));
        aa = -90.1D;
        System.out.println(aa.toString());
        System.out.println(RegexUtil.match(aa.toString(),regex));
        
        aa = +89.99D;
        System.out.println(aa.toString());
        System.out.println(RegexUtil.match(aa.toString(),regex));
        
        regex = "^((\\-|\\+)?((180(.0{0,2}))|(((1[0-7]\\d)|(\\d{1,2}))(\\.\\d+)?)))$";
        double a = 1;
        System.out.println(a);
        System.out.println(RegexUtil.match("+119",regex));
    }
    
    @Test
    public void test14() {
        String regex = "^((\\-|\\+)?((180)|(((1[0-7]\\d)|(\\d{1,2}))(\\.\\d+)?)))$";
        double a = 1;
        System.out.println(a);
        String str = "181";
        System.out.println(str + " : "+RegexUtil.match(str,regex));
        str = "180.99";
        System.out.println(str + " : "+RegexUtil.match(str,regex));
        str = "-179.99";
        System.out.println(str + " : "+RegexUtil.match(str,regex));
        str = "+179.99";
        System.out.println(str + " : "+RegexUtil.match(str,regex));
        str = "0";
        System.out.println(str + " : "+RegexUtil.match(str,regex));
        str = "+179.01";
        System.out.println(str + " : "+RegexUtil.match(str,regex));
        str = "+179";
        System.out.println(str + " : "+RegexUtil.match(str,regex));
        str = "-180.0";
        System.out.println(str + " : "+RegexUtil.match(str,regex));
        str = "+179.0";
        System.out.println(str + " : "+RegexUtil.match(str,regex));
    }
}
