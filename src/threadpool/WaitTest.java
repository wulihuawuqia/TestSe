/**
 * 版权所有: wulihua
 * 创建日期: 2019/9/21
 * 创建作者：wuqia
 * 文件名称：WaitTest.java
 * 版本: 1.0
 * 修改记录:
 */
package threadpool;

/**
 * Description: wait Test.
 * @author wuqia
 * @since 2019/9/21
 */
public class WaitTest implements Runnable{

    Boolean lock;

    static ThreadLocal<String> threadLocal = new ThreadLocal<>();

    WaitTest(Boolean lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        String threadStr = threadLocal.get();
        if (null != threadStr) {
            System.out.println(threadStr);
        } else {
            threadLocal.set(Thread.currentThread().getName());
        }
        synchronized (lock){
            Long curTime;
            int count = 5;
            while (count-- > 0) {
                try {
                    lock.notifyAll();
                    curTime = System.currentTimeMillis()/1000;
                    System.out.println(Thread.currentThread().getName() + "curTime" + curTime);
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            curTime = System.currentTimeMillis()/1000;
            System.out.println(Thread.currentThread().getName() + "curTime" + curTime);
        }
        System.out.println("threadLocal：" + threadLocal.get());
    }

    public static void main(String[] args) {
        Boolean lock = Boolean.TRUE;
        threadLocal.set(Thread.currentThread().getName());
        new Thread(new WaitTest(lock),"A").start();
        new Thread(new WaitTest(lock),"B").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("中文main out");
        synchronized (lock) {
            lock.notifyAll();
        }
        System.out.println("threadLocal：" + threadLocal.get());
    }
}
