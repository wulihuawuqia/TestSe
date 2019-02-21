/**
 * 版权所有: wulihua
 * 创建日期: 2019/2/20
 * 创建作者：wuqia
 * 文件名称：SafeInterrupt.java
 * 版本: 1.0
 * 修改记录:
 */
package interrupt;


/**
 * Description: 安全的中断.
 * @author wuqia
 * @since 2019/2/20
 */
public class SafeInterrupt implements Runnable {

    private volatile boolean on = true;
    private long i = 0;

    @Override
    public void run() {
        while(!Thread.currentThread().isInterrupted()) {
            System.out.println(Thread.currentThread().isInterrupted());
            i ++;
        }
        System.out.println("test :" + i);
    }

    public void cancel() {
        on = false;
        //Thread.interrupted();
        //interrupt
    }

    public static void main(String[] args) throws InterruptedException {
        SafeInterrupt safeInterrupt = new SafeInterrupt();
        Thread thread = new Thread(safeInterrupt);
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
        //safeInterrupt.cancel();
    }
}
