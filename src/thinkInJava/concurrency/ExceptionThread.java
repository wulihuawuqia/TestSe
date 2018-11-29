/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年12月22日 上午11:04:28
* 创建作者：伍恰
* 文件名称：ExceptionThread.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionThread implements Runnable {

    @Override
    public void run() {
        throw new RuntimeException();
    }
    
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new ExceptionThread());
    }
}
