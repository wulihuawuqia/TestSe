/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年12月21日 下午5:06:23
* 创建作者：伍恰
* 文件名称：DaemonFactory.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class DaemonFactory implements Runnable {

    @Override
    public void run() {
        try {
            while(true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " +this);
            }
        } catch (Exception e) {
            System.out.println("sleep () interrupted ");
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for(int i = 0; i < 10; i++) {
            exec.execute(new DaemonFactory());
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(1000);
    }
}
