/**
 * 版权所有: wulihua
 * 创建日期: 2019/9/24
 * 创建作者：wuqia
 * 文件名称：LockTemplete.java
 * 版本: 1.0
 * 修改记录:
 */
package lock;

import threadpool.ThreadPoolUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static threadpool.ThreadPoolUtils.getThredPool;

/**
 * Description: 锁模板.
 * @author wuqia
 * @since 2019/9/24
 */
public class LockTemplete {


    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        ExecutorService executorService = ThreadPoolUtils.getThredPool();
        for (int i = 0; i < 20; i++) {
            executorService.execute(new ThreadLock(lock, "thread"+i));
        }
        executorService.shutdown();
    }

    public void run(){

    }

    static class ThreadLock implements Runnable {

        private Lock lock;

        private String name;

        ThreadLock(Lock lock, String name) {
            this.lock=lock;
            this.name = name;
        }

        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println(name + "is runing");
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
    }
}
