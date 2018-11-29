/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年8月21日 下午4:48:57
* 创建作者：伍恰
* 文件名称：ThreadTest.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package api.concurrence;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest implements Runnable{
    private int i = 100;
    private AtomicInteger j = new AtomicInteger(100);
    @Override
    public void run() {
        // TODO Auto-generated method stub
        /*synchronized (this) {
            for (; i < 250; i++){
                System.out.println(Thread.currentThread().getName() + " loop " + i);
            }
        }*/
        /*while (i > 0) {
            add2();
        }*/
        add21();
        //add();
        //add2();
    	//add3();
        //add4();
    }
    
    public synchronized void add() {
        for (; i > 0; i--){
            System.out.println(Thread.currentThread().getName() + " loop " + i);
        }
    }
    public void add2() {
        System.out.println(Thread.currentThread().getName() + " loop " + i--);
    }

    public void add21() {
        for (; i > 0; i--){
            System.out.println(Thread.currentThread().getName() + " loop " + i);
        }
    }

    public  void add3() {
    	while (j.get() > 0) {
			int p = j.decrementAndGet();
			System.out.println(Thread.currentThread().getName() + " loop " + p);
		}
    }

    public  void add4() {
        synchronized (this){
            for (; i > 0; i--){
                System.out.println(Thread.currentThread().getName() + " loop " + i);
            }
        }
    }

    public static void main(String[] args) {
        ThreadTest t1 = new ThreadTest();
        Thread ta = new Thread(t1, "A");
        Thread tb = new Thread(t1, "B");


        /*try {
            Thread.currentThread().sleep(5);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        //t1.add();
        /*try {
            ta.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        tb.start();
        try {
            tb.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ta.start();
        //t1.add();
    }

}
