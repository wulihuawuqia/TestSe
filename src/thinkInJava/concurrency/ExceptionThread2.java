/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年12月22日 上午11:07:28
* 创建作者：伍恰
* 文件名称：ExceptionThread2.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.concurrency;

public class ExceptionThread2 implements Runnable {
    
    @Override
    public void run() {
        Thread t = Thread.currentThread();
        System.out.println("run() by "+ t);
        System.out.println("eh = "+t.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }

}
