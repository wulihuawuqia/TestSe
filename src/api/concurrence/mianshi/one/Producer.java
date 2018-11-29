package api.concurrence.mianshi.one;

import java.util.List;
import java.util.concurrent.BlockingQueue;

import com.alibaba.fastjson.JSON;

public class Producer implements Runnable {
	
	private BlockingQueue<List> queue;
	
	private Db db;

	public Producer(BlockingQueue<List> queue, Db db) {
		this.queue = queue;
		this.db = db;
	}
	
	@Override
	public void run() {
		while(true) {
			exec();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 
	* @Title: exec
	* @Description:处理数据
	* @return void 返回类型描述
	* @throws
	* @data 2018年1月12日 上午10:07:10
	* @author wuqia
	 * @throws InterruptedException 
	 */
	private void exec() {
		List<String> list = db.getData();
		try {
			queue.put(list);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(JSON.toJSONString(list) + "入队");
		
	}

}
