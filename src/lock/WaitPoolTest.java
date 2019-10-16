/**
 * 版权所有: wulihua
 * 创建日期: 2019/9/28
 * 创建作者：wuqia
 * 文件名称：WaitPoolTest.java
 * 版本: 1.0
 * 修改记录:
 */
package lock;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * Description: 等待通知案例.
 * @author wuqia
 * @since 2019/9/28
 */
public class WaitPoolTest {

    Logger logger = Logger.getLogger(getClass().getSimpleName());

    public static class Pool {

        Logger logger = Logger.getLogger(getClass().getSimpleName());
        /**
         * 资源容器
         */
        List<Object> list = new LinkedList<>();

        Pool(int num) {
            for (int i = 0; i < num; i++) {
                list.add("资源" + i);
            }
        }

        /**
         * 获取资源
         * @param mis 获取资源超时时间
         * @return
         */
        public Object get(Long mis) throws InterruptedException {
            Object result = null;
            synchronized (list) {
                // 超时时间
                Long limit = System.currentTimeMillis() + mis;
                // 时间间隔
                Long cur = System.currentTimeMillis() - limit;
                while(list.isEmpty() && cur < 0) {
                    list.wait(mis);
                    cur = System.currentTimeMillis() - limit;
                }
                if(!list.isEmpty() && cur < 0) {
                    result = list.remove(0);
                }
            }
            return result;
        }

        /**
         * 释放资源
         * @param o
         */
        public void put(Object o) {
            synchronized (list) {
                logger.info("释放资源：" + o);
                list.add(o);
                /* 提醒其他线程*/
                list.notifyAll();
            }
        }
    }

    public static class Runner implements Runnable {
        private Pool pool;

        Runner(Pool pool) {
            this.pool = pool;
        }

        @Override
        public void run() {
            try {
                Object result = pool.get(1000L);
                if (null == result) {
                    System.out.println(Thread.currentThread().getName() +"获取资源失败" );
                } else {
                    System.out.println(Thread.currentThread().getName() +"获取资源"+result+"成功,并处理任务" );
                    Thread.sleep(100);
                    pool.put(result);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Pool pool = new Pool(5);
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for(int i = 0; i < 100;  i++) {
            threadPool.execute(new Runner(pool));
        }
        threadPool.shutdown();
    }
}
