/**
 * 版权所有: 中国电信爱WiFi运营中心
 * 创建日期: 2018/3/20
 * 创建作者：wuqia
 * 文件名称：TryTest.java
 * 版本: 1.0
 * 修改记录:
 */
package test;

/**
 * Description: .
 * @author wuqia
 * @since 2018/3/20
 */
public class TryTest {
    public static void main(String[] args) {
        System.out.println(String.valueOf(001));
        System.out.println(test());
    }

    protected static boolean test(){
        try {
            System.out.println(1);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(2);
            return false;
        }
    }
}
