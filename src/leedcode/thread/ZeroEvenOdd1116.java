/**
 * 版权所有: wulihua
 * 创建日期: 2019/10/13
 * 创建作者：wuqia
 * 文件名称：ZeroEvenOdd1116.java
 * 版本: 1.0
 * 修改记录:
 */
package leedcode.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * Description: 打印零与奇数和偶数.
 * @author wuqia
 * @since 2019/10/13
 */
public class ZeroEvenOdd1116 {

    class ZeroEvenOdd {
        private int n;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        Semaphore z = new Semaphore(1);
        Semaphore e = new Semaphore(0);
        Semaphore o = new Semaphore(0);

        public void zero(IntConsumer printNumber) throws InterruptedException {
            for(int i=0; i<n;i++) {
                z.acquire();
                printNumber.accept(0);
                if((i&1)==0) {
                    o.release();
                }else {
                    e.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for(int i=2; i<=n; i+=2) {
                e.acquire();
                printNumber.accept(i);
                z.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for(int i=1; i<=n; i+=2) {
                o.acquire();
                printNumber.accept(i);
                z.release();
            }
        }
    }


    class ZeroEvenOddLock {
        private int n;

        public ZeroEvenOddLock(int n) {
            this.n = n;
        }

        private Lock lock = new ReentrantLock();
        private Condition z = lock.newCondition();
        private Condition e = lock.newCondition();
        private Condition o = lock.newCondition();
        private CountDownLatch start = new CountDownLatch(2);

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            start.await();
            lock.lock();
            try{
                for(int i = 0; i < n; i++){
                    printNumber.accept(0);
                    if((i&1)==0) {
                        o.signal();
                    } else {
                        e.signal();
                    }
                    z.await();
                }
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            lock.lock();
            start.countDown();
            try{
                for(int i = 2; i <= n; i+=2){
                    e.await();
                    printNumber.accept(i);
                    z.signal();
                }
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {

            lock.lock();
            start.countDown();
            try {
                for (int i = 1; i <= n; i += 2) {
                    o.await();
                    printNumber.accept(i);
                    z.signal();
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    class ZeroEvenOddLock1 {
        private int n;

        public ZeroEvenOddLock1(int n) {
            this.n = n;
        }

        private CountDownLatch z = new CountDownLatch(0);
        private CountDownLatch e = new CountDownLatch(1);
        private CountDownLatch o = new CountDownLatch(1);

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
                for(int i = 0; i < n; i++){
                    z.await();
                    z = new CountDownLatch(1);
                    printNumber.accept(0);
                    if((i&1)==0) {
                        o.countDown();
                    } else {
                        e.countDown();
                    }
                }

        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                e.await();
                e = new CountDownLatch(1);
                printNumber.accept(i);
                z.countDown();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                o.await();
                o = new CountDownLatch(1);
                printNumber.accept(i);
                z.countDown();
            }
        }
    }
}
