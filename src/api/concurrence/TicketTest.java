/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年8月21日 下午5:19:33
* 创建作者：伍恰
* 文件名称：TicketTest.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package api.concurrence;

public class TicketTest implements Runnable {
    private volatile static int num = 100;
    private volatile static int outnum = 0;
    @Override
    public void run() {
        // TODO Auto-generated method stub
        /*synchronized (this) {
            while (num > 0){
                num--;
                System.out.println(Thread.currentThread().getName()+" 消费一张 ");
                System.out.println(" 还剩 "+num);
            }
        }*/
        while (num > 1){
            synchronized (this) {
                num--;
                outnum++;
                System.out.println(Thread.currentThread().getName()+" 消费一张 ");
                System.out.println(" 还剩 "+num);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        System.out.println(" 已出 " + outnum);
    }
    
    public static void main(String[] args) {
        TicketTest tt = new TicketTest();
        Thread ta = new Thread(tt, "A");
        Thread tb = new Thread(tt, "B");
        ta.start();
        tb.start();
    }
    
}
