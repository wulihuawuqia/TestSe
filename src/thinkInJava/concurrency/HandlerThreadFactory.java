/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年12月22日 上午11:11:47
* 创建作者：伍恰
* 文件名称：HandlerThreadFactory.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class HandlerThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + "creating new Thread");
        Thread t = new Thread(r);
        System.out.println("create" + t);
        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh = " + t.getUncaughtExceptionHandler());
        return t;
    }
    
    public static void main(String[] args) {
        ExecutorService exec =  Executors.newCachedThreadPool(new HandlerThreadFactory());
        exec.execute(new ExceptionThread2());
    }
}
