/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月13日 下午7:40:35
* 创建作者：伍恰
* 文件名称：SimpleException.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.exception;

class SimpleException extends Exception{
    
}
public class SimpleExceptionTest {
    public void f() throws SimpleException {
        System.out.println("Throw SimpleException ");
        throw new SimpleException();
    }
    public static void main(String[] args) {
        SimpleExceptionTest set = new SimpleExceptionTest();
        try {
            set.f();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            System.out.println("caught it !");
        }finally {
            System.out.println("finally");
        }
    }
}
