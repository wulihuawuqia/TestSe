package api.concurrence.atomictest;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述:
 *
 * @author qia.wu
 * @create 2019-10-25 14:43
 * @see api.concurrence.atomictest
 */
public class AtomitIntegerTest {

	AtomicInteger count = new AtomicInteger(0);

	@Test
	public void add() {
		System.out.println(count);
		count.incrementAndGet();
		System.out.println(count);
		count.set(3);
		System.out.println(count);
	}
}
