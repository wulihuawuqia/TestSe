/**
 * 版权所有: wulihua
 * 创建日期: 2019/9/22
 * 创建作者：wuqia
 * 文件名称：TestMethod.java
 * 版本: 1.0
 * 修改记录:
 */
package acm;

import org.hamcrest.core.Is;

/**
 * Description: .
 * @author wuqia
 * @since 2019/9/22
 */
public class TestMethod {

    public static boolean isOdd(int i) {
        return (i & 1) == 1;
    }

    public static final boolean isOdd1(int i) {
        return i % 2 != 0;
    }

    public static void main(String[] args) {
        System.out.println(isOdd(1));
        System.out.println(isOdd(2));
        System.out.println(isOdd(-1));
        System.out.println(isOdd(1));
        System.out.println(isOdd(2));
        System.out.println(isOdd1(-1));
    }
}
