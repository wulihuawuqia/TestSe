/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年12月22日 上午9:53:04
* 创建作者：伍恰
* 文件名称：InnerThread2.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package thinkInJava.concurrency;

public class InnerThread2 {
    private int countDown = 5;
    private Thread t;
    public InnerThread2(String name) {
        t = new Thread(name) {
            public void run() {
                try {
                    while(true) {
                        System.out.println(this);
                        if(--countDown == 0) {
                            return;
                        }
                        sleep(10);
                    }
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
            @Override
            public String toString() {
                return getName() + ": "+countDown;
            }
        };
        t.start();
    }
    
    public static void main(String[] args) {
        new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
    }
}
