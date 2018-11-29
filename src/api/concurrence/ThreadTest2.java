/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年12月1日 下午3:18:06
* 创建作者：伍恰
* 文件名称：ThreadTest2.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package api.concurrence;

public class ThreadTest2 extends Thread {
    boolean flag = true;
    @Override
    public void run() {
        System.out.println("线程执行");
        
        while(flag) {
            System.out.println(flag);
        }
        System.out.println("结束");
    }
    
    public static void main(String[] args) {
        ThreadTest2  t = new ThreadTest2();
        t.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        t.flag = false;
        System.out.println("完成");
    }
}
