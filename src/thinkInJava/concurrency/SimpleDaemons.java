/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年12月21日 下午5:00:20
* 创建作者：伍恰
* 文件名称：SimpleDaemons.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.concurrency;

import java.util.concurrent.TimeUnit;

public class SimpleDaemons implements Runnable {

    @Override
    public void run() {
        try {
            while(true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread() + " " +this);
            }
        } catch (Exception e) {
            System.out.println("sleep () interrupted ");
        } finally {
            System.out.println("add");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 10; i++) {
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        System.out.println("All daemons started");
        TimeUnit.MILLISECONDS.sleep(1000);
    }
}
