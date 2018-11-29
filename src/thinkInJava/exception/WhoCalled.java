/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月13日 下午8:24:36
* 创建作者：伍恰
* 文件名称：WhoCalled.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.exception;

public class WhoCalled {
    static void f(){
        try {
            throw new Exception("test");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            for(StackTraceElement ste : e.getStackTrace()){
                System.out.println(ste.getMethodName());
            }
        }
    }
    static void g(){
        f();
    }
    static void h(){
        g();
    }
    public static void main(String[] args) {
        f();
        System.out.println("---------");
        g();
        System.out.println("---------");
        h();
    }
}
