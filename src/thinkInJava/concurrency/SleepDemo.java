/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年12月21日 上午10:07:14
* 创建作者：伍恰
* 文件名称：SleepDemo.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.concurrency;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepDemo extends Thread {
    private int i;
    
    SleepDemo(int i){
        this.i = i;
    }
    public void run() {
        System.out.println(i+"启动");
        Random rand = new Random();
        Long time = (long) rand.nextInt(10);
        System.out.println("休眠时间"+time);
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(i+"结束");
    }
    
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++) {
            exec.execute(new SleepDemo(i));
        }
    }
}
