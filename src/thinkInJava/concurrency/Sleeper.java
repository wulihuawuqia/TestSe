/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年12月22日 上午10:18:18
* 创建作者：伍恰
* 文件名称：Sleeper.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.concurrency;

public class Sleeper extends Thread {
    private int duration;
    
    public Sleeper(String name, int sleepTime) {
        super(name);
        duration = sleepTime;
        start();
    }
    
    public void run() {
        System.out.println(getName() +"开始");
        try {
            sleep(duration);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(getName() +"执行完毕");
    }
}
