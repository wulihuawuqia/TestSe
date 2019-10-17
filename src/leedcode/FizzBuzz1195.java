/**
 * 版权所有: wulihua
 * 创建日期: 2019/10/17
 * 创建作者：wuqia
 * 文件名称：FizzBuzz1195.java
 * 版本: 1.0
 * 修改记录:
 */
package leedcode;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * Description: 交替答应字符串.
 * @author wuqia
 * @since 2019/10/17
 */
public class FizzBuzz1195 {

    @Test
    public void test () {
        AtomicInteger i = new AtomicInteger(1);
        for (; i.get() <= 5 ; i.incrementAndGet()) {
            System.out.println(i.get());
        }
    }

    class FizzBuzz {

        private int n;


        public FizzBuzz(int n) {
            this.n = n;
        }

        private CountDownLatch fizz = new CountDownLatch(1);
        private CountDownLatch buzz = new CountDownLatch(1);
        private CountDownLatch fizzbuzz = new CountDownLatch(1);
        private CountDownLatch number = new CountDownLatch(3);

        private volatile AtomicInteger i = new AtomicInteger(1);

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            number.countDown();
            while (i.get() <= n) {
                fizz.await();
                printFizz.run();
                fizz = new CountDownLatch(1);
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            number.countDown();
            while (i.get() <= n) {
                buzz.await();
                printBuzz.run();
                buzz = new CountDownLatch(1);
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            number.countDown();
            while (i.get() <= n) {
                fizzbuzz.await();
                printFizzBuzz.run();
                fizzbuzz = new CountDownLatch(1);
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            number.await();
            for (; i.get() <= n ; i.incrementAndGet()) {
                if (i.get()%3 == 0 && i.get()%5 == 0) {
                    fizzbuzz.countDown();
                } else if (i.get()%3 == 0){
                    fizz.countDown();
                } else if (i.get()%5 == 0){
                    buzz.countDown();
                } else {
                    printNumber.accept(i.get());
                }
            }
        }
    }

    @Test
    public void main() throws InterruptedException {
        FizzBuzz foo = new FizzBuzz(5);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.fizz(new Runnable() {
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
                    foo.buzz(new Runnable() {
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

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.fizzbuzz(new Runnable() {
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

        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.number((int i) -> {
                        System.out.println(i);
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });



        ExecutorService threadPool = Executors.newCachedThreadPool();
        threadPool.execute(t4);
        threadPool.execute(t1);
        threadPool.execute(t2);
        threadPool.execute(t3);


        threadPool.shutdown();

    }
}
