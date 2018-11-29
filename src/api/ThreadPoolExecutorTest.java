/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年7月13日 下午8:33:55
* 创建作者：伍恰
* 文件名称：ThreadPoolExecutorTest.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package api;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 * 线程类
 * @author 伍恰
 * 2017年7月13日 下午8:39:24
 */
class MyTask implements Runnable {
    private int taskNum;
    public MyTask(int taskNum) {
        // TODO Auto-generated constructor stub
        this.taskNum = taskNum;
    }
    @SuppressWarnings("static-access")
    @Override
    public void run() {
        // TODO Auto-generated method stub
        System.out.println("正在执行task :"+taskNum);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("task"+taskNum+"执行完毕！");
    }
    
}
public class ThreadPoolExecutorTest {
    public static void main(String[] args) {
        int corePoolSize = 5;//核心线程数
        int maximumPoolSize = 10;//最大线程数
        long keepAliveTime = 200;//表示线程没有任务执行时最多保持多久时间会终止
        TimeUnit unit = TimeUnit.MINUTES; //表示keepAliveTime的耽误
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(10);//阻塞队列
        ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
        
        // = (ThreadPoolExecutor) Executors.newCachedThreadPool();        //创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
        //Executors.newSingleThreadExecutor();   //创建容量为1的缓冲池
        //Executors.newFixedThreadPool(12);    //创建固定容量大小的缓冲池
        //创建线程
        for(int i = 0; i<100; i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目:"+executor.getPoolSize());
            System.out.println("线程池执行中线程："+executor.getQueue().size());
            System.out.println("已经执行完线程数："+executor.getCompletedTaskCount());
        }
    }
}
