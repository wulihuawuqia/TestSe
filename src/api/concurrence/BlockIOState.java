/**
 * 版权所有: wulihua
 * 创建日期: 2019/10/13
 * 创建作者：wuqia
 * 文件名称：BlockIOState.java
 * 版本: 1.0
 * 修改记录:
 */
package api.concurrence;

import org.junit.Test;

import java.util.Scanner;

/**
 * Description: 阻塞IO时线程的状态.
 * @author wuqia
 * @since 2019/10/13
 */
public class BlockIOState {

    @Test
    public void test() throws InterruptedException {
        Scanner in = new Scanner(System.in);

        Thread t = new Thread(() -> {
            String input = in.nextLine();
            System.out.println(input);
        });

        t.start();

        Thread.sleep(10000L);

        System.out.println(t.getState());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();
        System.out.println(input);
        System.out.println(Thread.currentThread().getState());
    }


}
