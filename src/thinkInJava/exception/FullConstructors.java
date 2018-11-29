/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月13日 下午7:56:49
* 创建作者：伍恰
* 文件名称：FullConstructors.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.exception;

class MyException extends Exception{
    public MyException (){
        
    }
    public MyException (String msg){
        super(msg);
    }
}
public class FullConstructors {
    public static void f() throws MyException {
        System.out.println("Throwing MyException form f()");
        throw new MyException();
    }
    public static void g() throws MyException {
        System.out.println("Throwing MyException form f()");
        throw new MyException("g ");
    }
    public static void main(String[] args) {
        try {
            f();
        } catch (MyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace(System.out);
        }
        try {
            g();
        } catch (MyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace(System.out);
        }
        
    }
}
