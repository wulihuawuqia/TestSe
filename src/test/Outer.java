/**
 * 版权所有: wulihua
 * 创建日期: 2019/1/12
 * 创建作者：wuqia
 * 文件名称：Outer.java
 * 版本: 1.0
 * 修改记录:
 */
package test;

import org.junit.Test;

/**
 * Description: 跳到指定执行.
 * @author wuqia
 * @since 2019/1/12
 */
public class Outer {

    @Test
    public void outerTest() {
        outer:
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            if (i > 8) {
                continue outer;
            }
        }
    }
}
