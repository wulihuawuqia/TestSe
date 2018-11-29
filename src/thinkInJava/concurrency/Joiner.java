/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年12月22日 上午10:21:43
* 创建作者：伍恰
* 文件名称：Joiner.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.concurrency;

public class Joiner extends Thread {
    private Sleeper sleeper;
    public Joiner(String name, Sleeper sleeper) {
        super(name);
        this.sleeper = sleeper;
        start();
    }
    
    public void run() {
        System.out.println(getName() +"开始");
        try {
            sleeper.join();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(getName() + ":" +"完毕");
    }
    
    public static void main(String[] args) {
        Sleeper sleeper = new Sleeper("Sleeper", 1500);
        Joiner joiner = new Joiner("Joiner", sleeper);
    }
}
