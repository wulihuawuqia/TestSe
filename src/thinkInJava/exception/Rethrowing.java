/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月13日 下午8:29:22
* 创建作者：伍恰
* 文件名称：Rethrowing.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.exception;

public class Rethrowing {
    public static void f() throws Exception{
        System.out.println("originating the exceptin in f()");
        throw new Exception("throw from f()");
    }
    public static void g() throws Exception{
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside g(),e");
            e.printStackTrace(System.out);
            throw e;
        }
    }
    public static void h() throws Exception{
        try {
            f();
        } catch (Exception e) {
            System.out.println("Inside h(),e");
            e.printStackTrace(System.out);
            throw (Exception)e.fillInStackTrace();
        }
    }
    public static void main(String[] args) {
        try {
            g();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            h();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
