/**
 * 版权所有: wulihua
 * 创建日期: 2019/10/12
 * 创建作者：wuqia
 * 文件名称：WaitPoolCondition.java
 * 版本: 1.0
 * 修改记录:
 */
package lock;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * Description: 等待队列池.
 * @author wuqia
 * @since 2019/10/12
 */
public class WaitPoolCondition {

    public static class WaitPool {
        final Lock lock = new ReentrantLock();
        final Condition notFull = lock.newCondition();
        final Condition notEmpty = lock.newCondition();

        private Integer count;

        List<Integer> list ;

        WaitPool(Integer num) {
            count = num;
            list = new ArrayList<>(num);
            for (int i = 0; i < num; i++) {
                list.add(i);
            }
        }

        public Integer get (Long time) {
            Integer result = null;
            lock.lock();
            try {
                Long limit = System.currentTimeMillis() + time;
                Long cur = limit - System.currentTimeMillis();
                while (cur > 0 && list.size() == 0) {
                    notEmpty.await(time, TimeUnit.MILLISECONDS);
                    cur = limit - System.currentTimeMillis();
                }
                if(!list.isEmpty() && cur > 0) {
                    result = list.remove(0);
                    notFull.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
            return result;
        }

        public void put (Integer val) {
            lock.lock();
            try {
                Long limit = System.currentTimeMillis() + 1000;
                Long cur = limit - System.currentTimeMillis();
                while (cur > 0 && count == list.size()) {
                    System.out.println(System.currentTimeMillis() +"size :" + list.size());
                    notFull.await(1000, TimeUnit.MILLISECONDS);
                    cur = limit - System.currentTimeMillis();
                }
                if (count > list.size()) {
                    System.out.println(Thread.currentThread().getName() +"插入资源成功" );
                    list.add(val);
                    notEmpty.signal();
                } else {
                    System.out.println(Thread.currentThread().getName() +"插入资源失败" );
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }

    public static class Runner implements Runnable {
        private WaitPool pool;

        Runner(WaitPool pool) {
            this.pool = pool;
        }

        @Override
        public void run() {
            try {
                Integer result = pool.get(1000L);
                Thread.sleep(1000);
                if (null == result) {
                    System.out.println(Thread.currentThread().getName() +"获取资源失败" );
                } else {
                    System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() +"获取资源"+result+"成功,并处理任务" );
                    //pool.put(result);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class SetRunner implements Runnable {
        private WaitPool pool;

        SetRunner(WaitPool pool) {
            this.pool = pool;
        }

        @Override
        public void run() {
            try {
                pool.put(1);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        WaitPool pool = new WaitPool(5);
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for(int i = 0; i < 100;  i++) {
            threadPool.execute(new Runner(pool));
        }
        for(int i = 0; i < 1000;  i++) {
            threadPool.execute(new SetRunner(pool));
        }
        threadPool.shutdown();
    }
}
