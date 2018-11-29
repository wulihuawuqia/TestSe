package api.concurrence.mianshi.one;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;

import com.alibaba.fastjson.JSON;

public class Consumer implements Runnable {
	
	private BlockingQueue<List> queue ;
	private ExecutorService threadPool ;
	
	public Consumer(BlockingQueue<List> queue ,ExecutorService threadPool ) {
		this.queue = queue;
		this.threadPool = threadPool;
	}
	
	@Override
	public void run() {
		while(true) {
			exec();
		}
	}
	
	private void exec() {
		CountDownLatch latch = new CountDownLatch(5);
		List<String> list = null;
		try {
			list = queue.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(JSON.toJSONString(list) + "出队！！！");
		for (String data : list) {
			threadPool.execute(new ConsumerSon(latch, data));
		}
		//等待任务完成
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(JSON.toJSONString(list) + "任务完成！！！");
	}

}
