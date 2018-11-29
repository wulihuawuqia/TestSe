package api.concurrence.mianshi.one;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
	
	
	public Main() {
		
	}
	
	public static void main(String[] args) {
		//初始化
		BlockingQueue<List> queue = new ArrayBlockingQueue<>(100);
		Db db = new Db();
		
		ExecutorService threadPool = Executors.newCachedThreadPool();
		//加入生产者
		threadPool.execute(new Producer(queue, db));
		//加入消费者
		threadPool.execute(new Consumer(queue, threadPool));
		
	}
}
