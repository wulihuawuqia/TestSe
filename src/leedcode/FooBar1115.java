/**
 * 版权所有: wulihua
 * 创建日期: 2019/10/13
 * 创建作者：wuqia
 * 文件名称：FooBar1115.java
 * 版本: 1.0
 * 修改记录:
 */
package leedcode;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description: 交替打印.
 * @author wuqia
 * @since 2019/10/13
 */
public class FooBar1115 {

    @Test
    public void main() throws InterruptedException {
        FooBarNew foo = new FooBarNew(5);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.foo(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("foo");
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.bar(new Runnable() {
                        @Override
                        public void run() {
                            System.out.print("bar");
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        ExecutorService threadPool = Executors.newCachedThreadPool();
        threadPool.execute(t1);
        Thread.sleep(1000L);
        threadPool.execute(t2);
        while (t1.getState().equals(Thread.State.TERMINATED) && t2.getState().equals(Thread.State.TERMINATED)) {

        }
        threadPool.shutdown();

    }

     class FooBar {
        private int n;

        private Lock lock = new ReentrantLock();
        private Condition foobar = lock.newCondition();
        private Condition bar = lock.newCondition();
        private volatile Boolean bool = Boolean.FALSE;
        private CountDownLatch start = new CountDownLatch(1);

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {
            start.await();
            lock.lock();
            try{
                for (int i = 0; i < n; i++) {
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    bar.signal();
                    foobar.await();
                }
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {
            lock.lock();
            start.countDown();
            try{
                for (int i = 0; i < n; i++) {
                    bar.await();
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    foobar.signal();
                }
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    class FooBarNew {
        private int n;

        private CyclicBarrier foobar = new CyclicBarrier(2);
        private CyclicBarrier bar = new CyclicBarrier(2);

        public FooBarNew(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException{
            try {
                for (int i = 0; i < n; i++) {
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    bar.await();
                    foobar.await();
                    foobar.reset();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public void bar(Runnable printBar) throws InterruptedException {
            try {
                for (int i = 0; i < n; i++) {
                    bar.await();
                    bar.reset();
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    foobar.await();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
