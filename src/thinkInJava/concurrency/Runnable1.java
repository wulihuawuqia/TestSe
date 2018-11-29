/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年12月20日 下午3:06:38
* 创建作者：伍恰
* 文件名称：Runnable1.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.concurrency;

public class Runnable1 implements Runnable {
    
    Runnable1() {
        System.out.println(Thread.currentThread().getName()+"线程开始");
    }
    
    @Override
    public void run() {
        for(int i = 0; i<3 ;i++) {
            System.out.println(Thread.currentThread().getName()+"输出"+i);
            Thread.yield();
        }
        System.out.println("任务结束");
    }
    
    public static void main(String[] args) {
        for(int i = 0; i<10; i++) {
            new Thread(new Runnable1()).start();
        }
    }

}
