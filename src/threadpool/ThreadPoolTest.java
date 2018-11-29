/**
 * 版权所有: 中国电信爱WiFi运营中心
 * 创建日期: 2018/4/12
 * 创建作者：wuqia
 * 文件名称：ThreadPoolTest.java
 * 版本: 1.0
 * 修改记录:
 */
package threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description: 线程池测试.
 * @author wuqia
 * @since 2018/4/12
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 100, 200, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));
        for (int i = 0; i < 100; i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        while(executor.getQueue().size() > 0 && executor.getPoolSize() > 5) {
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();
    }
}
class MyTask implements Runnable {
    private int taskId;

    /**
     * @param taskId
     */
    public MyTask(int taskId){
        this.taskId = taskId;
    }

    @Override
    public void run() {
        System.out.println("正在执行task:" + taskId);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task:"+taskId+"执行完成！");
    }
}
