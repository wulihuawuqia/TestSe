package api.concurrence.mianshi.one;

import java.util.concurrent.CountDownLatch;

public class ConsumerSon implements Runnable{
	
	private CountDownLatch latch;
	
	private String data;
	
	public ConsumerSon(CountDownLatch latch, String data) {
		this.latch = latch;
		this.data = data;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(data+"处理完成");
		latch.countDown();
	}

}
