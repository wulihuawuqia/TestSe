/**
 * 版权所有: wulihua
 * 创建日期: 2020/11/14
 * 创建作者：wuqia
 * 文件名称：StringTest.java
 * 版本: 1.0
 * 修改记录:
 */
package test;

import org.junit.Test;

/**
 * Description: .
 * @author wuqia
 * @since 2020/11/14
 */
public class StringTest {

    @Test
    public void testIndex() {
        String a = "1234";
        System.out.println(a.indexOf("1"));
        System.out.println(a.indexOf("12"));
        System.out.println(a.indexOf("2"));
        System.out.println(a.indexOf("6"));
    }
}
