/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年12月22日 上午9:42:51
* 创建作者：伍恰
* 文件名称：InnerThread1.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.concurrency;

public class InnerThread1 {
    private int countDown = 5;
    private Inner inner;
    private class Inner extends Thread {
        public Inner(String name) {
            super(name);
            start();
        }
        
        public void run() {
            try {
                while(true) {
                    System.out.println(this);
                    if(--countDown == 0) {
                        return ;
                    }
                    sleep(10);
                }
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        public String toString() {
            return getName() + ": "+countDown;
        }
    }
    public InnerThread1(String name) {
        inner = new Inner(name);
    }
}
