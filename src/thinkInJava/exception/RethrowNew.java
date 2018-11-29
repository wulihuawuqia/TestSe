/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月13日 下午8:37:47
* 创建作者：伍恰
* 文件名称：RethrowNew.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.exception;

class OneException extends Exception{
    public OneException(String msg){
        super(msg);
    }
}
class TwoException extends Exception{
    public TwoException(String msg){
        super(msg);
    }
}
public class RethrowNew {
    public static void f() throws OneException{
        System.out.println("originating the exception in f()");
        throw new OneException("one");
    }
    public static void main(String[] args) {
        try {
            try {
                f();
            } catch (OneException e) {
                // TODO Auto-generated catch block
                System.out.println("caught in inner try , e");
                e.printStackTrace(System.out);
                throw new TwoException("two");
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        
    }
}
