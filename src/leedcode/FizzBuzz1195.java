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

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
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

        private volatile Semaphore fizz = new Semaphore(0);
        private volatile Semaphore buzz = new Semaphore(0);
        private volatile Semaphore fizzbuzz = new Semaphore(0);
        private volatile Semaphore number = new Semaphore(1);

        private volatile AtomicBoolean bool = new AtomicBoolean(true);

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            while (true) {
                fizz.acquire();
                if (!bool.get()) {
                	break;
				}
                printFizz.run();
				number.release();
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
			while (true) {
				buzz.acquire();
				if (!bool.get()) {
					break;
				}
				printBuzz.run();
				number.release();
			}
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
			while (true) {
				fizzbuzz.acquire();
				if (!bool.get()) {
					break;
				}
				printFizzBuzz.run();
				number.release();
			}
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
			for (int i = 1; i <= n; i++) {
				number.acquire();
                if (i%3 == 0 && i%5 == 0) {
                    fizzbuzz.release();
                } else if (i%3 == 0){
                    fizz.release();
                } else if (i%5 == 0){
                    buzz.release();
                } else {
                    printNumber.accept(i);
					number.release();
                }
            }
			number.acquire();
            bool.set(Boolean.FALSE);
			fizzbuzz.release(2);
			fizz.release(2);
			buzz.release(2);
        }
    }

	class FizzBuzz1 {

		private int n;


		public FizzBuzz1(int n) {
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
				number.countDown();
			}
		}

		// printBuzz.run() outputs "buzz".
		public void buzz(Runnable printBuzz) throws InterruptedException {
			number.countDown();
			while (i.get() <= n) {
				buzz.await();
				printBuzz.run();
				buzz = new CountDownLatch(1);
				number.countDown();
			}
		}

		// printFizzBuzz.run() outputs "fizzbuzz".
		public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
			number.countDown();
			while (i.get() <= n) {
				fizzbuzz.await();
				printFizzBuzz.run();
				fizzbuzz = new CountDownLatch(1);
				number.countDown();
			}
		}

		// printNumber.accept(x) outputs "x", where x is an integer.
		public void number(IntConsumer printNumber) throws InterruptedException {
			number.await();
			for (; i.get() <= n ; i.incrementAndGet()) {
				number.await();
				if (i.get()%3 == 0 && i.get()%5 == 0) {
					fizzbuzz.countDown();
					number = new CountDownLatch(1);
				} else if (i.get()%3 == 0){
					fizz.countDown();
					number = new CountDownLatch(1);
				} else if (i.get()%5 == 0){
					buzz.countDown();
					number = new CountDownLatch(1);
				} else {
					printNumber.accept(i.get());
				}
			}
		}
	}


	class FizzBuzz2 {

		private int n;


		public FizzBuzz2(int n) {
			this.n = n;
		}

		Semaphore sa = new Semaphore(0);
		Semaphore sb = new Semaphore(0);
		Semaphore sc = new Semaphore(0);
		Semaphore sd = new Semaphore(0);
		private int cur = 1;

		// printFizz.run() outputs "fizz".
		public void fizz(Runnable printFizz) throws InterruptedException {
			while(true) {
				sa.acquire();
				if (cur > n)
					break;
				printFizz.run();
				sd.release();
			}
		}

		// printBuzz.run() outputs "buzz".
		public void buzz(Runnable printBuzz) throws InterruptedException {
			while(true) {
				sb.acquire();
				if (cur > n)
					break;
				printBuzz.run();
				sd.release();
			}
		}

		// printFizzBuzz.run() outputs "fizzbuzz".
		public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
			while(true) {
				sc.acquire();
				if (cur > n)
					break;
				printFizzBuzz.run();
				sd.release();
			}
		}

		// printNumber.accept(x) outputs "x", where x is an integer.
		public void number(IntConsumer printNumber) throws InterruptedException {
			while(true) {
				if (cur % 3 != 0 && cur % 5 != 0){
					printNumber.accept(cur);
				} else if (cur % 3 == 0 && cur % 5 != 0){
					sa.release();
					sd.acquire();
				} else if (cur % 5 == 0 && cur % 3 != 0){
					sb.release();
					sd.acquire();
				} else {
					sc.release();
					sd.acquire();
				}
				cur++;
				if (cur > n) {
					sa.release();
					sb.release();
					sc.release();
					break;
				}
			}
		}
	}



    @Test
    public void main() throws InterruptedException {
        FizzBuzz foo = new FizzBuzz(15);

        Thread fizz = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.fizz(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("fizz");
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        Thread buzz = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.buzz(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("buzz");
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread fizzbuzz = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    foo.fizzbuzz(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("fizzbuzz");
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread number = new Thread(() -> {
			try {
				foo.number((int i) -> {
					System.out.println(i);
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		});



        ExecutorService threadPool = Executors.newCachedThreadPool();

		threadPool.execute(number);
		//Thread.sleep(1000);
        threadPool.execute(fizz);
		//Thread.sleep(1000);
        threadPool.execute(buzz);
		//Thread.sleep(1000);
        threadPool.execute(fizzbuzz);
		//Thread.sleep(1000);
		/*foo.fizz(new Runnable() {
			@Override
			public void run() {
				System.out.println("fizz");
			}
		});*/

		foo.fizzbuzz(new Runnable() {
			@Override
			public void run() {
				System.out.println("fizzbuzz");
			}
		});
		/*System.out.println(fizz.getState());
		System.out.println(buzz.getState());
		System.out.println(fizzbuzz.getState());
		System.out.println(Thread.currentThread().getState());*/
       /* foo.number((int i) -> {
            System.out.println(i);
        });*/
		//Thread.sleep(1000);
        threadPool.shutdown();

    }
}
