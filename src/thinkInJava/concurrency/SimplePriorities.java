/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年12月21日 上午10:32:30
* 创建作者：伍恰
* 文件名称：SimplePriorities.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimplePriorities implements Runnable{

    private int countDown = 5;
    private volatile double d;
    private int priority;
    
    public SimplePriorities(int priority) {
        this.priority = priority;
    }
    
    @Override
    public String toString() {
        return Thread.currentThread() + ": "+countDown;
    }
    
    @Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while(true) {
            for(int i = 1; i < 1000000; i++) {
                d += (Math.PI + Math.E) / (double)i;
                if(i % 1000 == 0) {
                    Thread.yield();
                }
            }
            System.out.println(this);
            if(--countDown == 0) {
                return ;
            }
        }
    }
    
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++) {
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();
    }

}
