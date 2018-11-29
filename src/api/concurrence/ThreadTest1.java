/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年8月21日 下午7:01:24
* 创建作者：伍恰
* 文件名称：ThreadTest1.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package api.concurrence;

public class ThreadTest1 {
    public void m4t1(){
        synchronized (this) {
            int i = 10;
            while( i-- > 0) {  
                System.out.println(Thread.currentThread().getName() + " : " + i);  
                try {  
                     Thread.sleep(500);  
                } catch (InterruptedException ie) {  
                }  
           }  
        }
    }
    public synchronized void m4t2() {  
        int i = 10;  
        while( i-- > 0) {  
             System.out.println(Thread.currentThread().getName() + " : " + i);  
             try {  
                  Thread.sleep(500);  
             } catch (InterruptedException ie) {  
             }  
        }  
    }
    public static void main(String[] args) {  
        final ThreadTest1 myt2 = new ThreadTest1();  
        Thread t1 = new Thread(  new Runnable() {  public void run() {  myt2.m4t1();  }  }, "t1"  );  
        Thread t2 = new Thread(  new Runnable() {  public void run() { myt2.m4t2();   }  }, "t2"  );  
        t1.start();  
        t2.start();  
   } 
}
