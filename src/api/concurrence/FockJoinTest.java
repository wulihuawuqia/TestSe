package api.concurrence;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 描述:
 * 内部分拆模型测试
 *
 * @author qia.wu
 * @create 2019-10-21 10:20
 * @see api.concurrence
 */
public class FockJoinTest extends RecursiveTask<Long> {
	private final int DEFAULT_CAPACITY = 100;

	private int start ;

	private int end ;

	public FockJoinTest(int start,int end){
		this.start= start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		long sum  = 0;

		if(end - start < DEFAULT_CAPACITY){
			for(int i=start ;i<end;i++){
				sum += i;
			}
		}else{
			int middle = (start+end)/2;

			FockJoinTest fockJoinTest1 = new FockJoinTest(start,middle);
			FockJoinTest fockJoinTest2 = new FockJoinTest(middle,end);

			fockJoinTest1.fork();
			fockJoinTest2.fork();

			sum = fockJoinTest1.join() + fockJoinTest2.join();
		}
		return sum;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		FockJoinTest fockJoinTest = new FockJoinTest(0,10000000);

		long fockjoinStartTime = System.currentTimeMillis();
		long result = forkJoinPool.invoke(fockJoinTest);
		System.out.println(result);
		System.out.println("fock/join计算结果耗时"+(System.currentTimeMillis() - fockjoinStartTime));
		fockjoinStartTime = System.currentTimeMillis();
		Long sum = 0L;
		for(int i=0 ;i<10000000;i++){
			sum += i;
		}
		System.out.println(sum);
		System.out.println("单线程计算结果耗时"+(System.currentTimeMillis() - fockjoinStartTime));
	}

}
