/**
 * 版权所有: wulihua
 * 创建日期: 2019/9/22
 * 创建作者：wuqia
 * 文件名称：ThreadPoolUtils.java
 * 版本: 1.0
 * 修改记录:
 */
package threadpool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description: .
 * @author wuqia
 * @since 2019/9/22
 */
public class ThreadPoolUtils {

    public static final ExecutorService getThredPool() {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        //Common Thread Pool
        //ExecutorService pool = new ThreadPoolExecutor(5, 200,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        /*ExecutorService singleThreadPool = new ThreadPoolExecutor(5, 20,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());*/
        ExecutorService singleThreadPool = new ThreadPoolExecutor(5, 20,
                0L, TimeUnit.MILLISECONDS,
                new SynchronousQueue<>(), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        return singleThreadPool;
    }

    @Test
    public void testTimeUnit() {
        System.out.println(TimeUnit.MILLISECONDS.toNanos(0));
    }
}
