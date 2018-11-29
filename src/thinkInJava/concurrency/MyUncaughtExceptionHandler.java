/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年12月22日 上午11:10:14
* 创建作者：伍恰
* 文件名称：My.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.concurrency;

public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught " +e);
    }

}
