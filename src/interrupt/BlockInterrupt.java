package interrupt;


import org.apache.poi.ss.formula.functions.T;
import threadpool.ThreadPoolUtils;

import java.util.concurrent.ExecutorService;

/**
 * 动脑学院-Mark老师
 * 创建日期：2017/11/26
 * 创建时间: 21:02
 * 调用阻塞方法时，如何中断线程
 */
public class BlockInterrupt {

    private static class WhenBlock implements Runnable {

        private Thread thread ;

        @Override
        public void run() {
            thread = Thread.currentThread();
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(System.currentTimeMillis());
                try {
                    //抛出中断异常的阻塞方法，抛出异常后，中断标志位改成false
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                    //重新设置一下
                    Thread.currentThread().interrupt();
                    //do my work
                }
                //清理工作结束线程
            }
            System.out.println("线程结束！");
            System.out.println("run:"+Thread.currentThread().isInterrupted());
        }

        public void cancel() {
            // Thread.currentThread() 获取的是调用此方法的线程
            thread.interrupt();
            System.out.println("cancel:"+thread.isInterrupted());
        }

        public Thread getThread() {
            return thread;
        }

        public void setThread(Thread thread) {
            this.thread = thread;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WhenBlock whenBlock = new WhenBlock();
        ExecutorService executorService = ThreadPoolUtils.getThredPool();
        executorService.execute(whenBlock);
        while (null == whenBlock.thread) {
            Thread.sleep(100);
        }
        whenBlock.cancel();
        executorService.shutdown();
    }
}