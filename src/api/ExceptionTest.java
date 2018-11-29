/**
* 版权所有： 爱WiFi无线运营中心
* 创建日期:2017年6月30日 上午10:53:41
* 创建作者：伍恰
* 文件名称：ExceptionTest.java
* 版本：  v1.0
* 功能：
* 修改记录：
*/
package api;

import org.junit.Test;

public class ExceptionTest {
    @Test
    public void testException1() {
        int[] ints = new int[] { 1, 2, 3, 4 };
        System.out.println("异常出现前");
        try {
            System.out.println(ints[4]);
            System.out.println("我还有幸执行到吗");// 发生异常以后，后面的代码不能被执行
        } catch (IndexOutOfBoundsException e) {
            System.out.println("数组越界错误");
            //throw new RuntimeException("数组越界错误");
        } finally {
            System.out.println("finally");
        }
        System.out.println("异常出现后");
    }
    @Test
    public void testException2() {
        int[] ints = new int[] { 1, 2, 3, 4 };
        System.out.println("异常出现前");
        try {
            System.out.println(ints[4]);
            System.out.println("我还有幸执行到吗");// 发生异常以后，后面的代码不能被执行
        } catch (IndexOutOfBoundsException e) {
            System.out.println("数组越界错误");
            throw new RuntimeException(e);
        }
        System.out.println("异常出现后");
    }
    @Test
    public void testException3() {
        int[] ints = new int[] { 1, 2, 3, 4 };
        System.out.println("异常出现前");
        System.out.println(ints[4]);
        System.out.println("我还有幸执行到吗");// 发生异常以后，他后面的代码不能被执行
    }
}
