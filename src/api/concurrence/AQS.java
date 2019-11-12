/**
 * 版权所有: wulihua
 * 创建日期: 2019/10/28
 * 创建作者：wuqia
 * 文件名称：AQS.java
 * 版本: 1.0
 * 修改记录:
 */
package api.concurrence;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Description: .
 * @author wuqia
 * @since 2019/10/28
 */
public class AQS {
    public static void main(String[] args) {
        AbstractQueuedSynchronizer abstractQueuedSynchronizer = new AbstractQueuedSynchronizer() {
            @Override
            protected boolean tryAcquire(int arg) {
                return super.tryAcquire(arg);
            }

            @Override
            protected boolean tryRelease(int arg) {
                return super.tryRelease(arg);
            }
        };
    }
}
