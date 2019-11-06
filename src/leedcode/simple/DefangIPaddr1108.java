/**
 * 版权所有: wulihua
 * 创建日期: 2019/10/27
 * 创建作者：wuqia
 * 文件名称：DefangIPaddr1108.java
 * 版本: 1.0
 * 修改记录:
 */
package leedcode.simple;

/**
 * Description: 返回ip 无效.
 * @author wuqia
 * @since 2019/10/27
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 *
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 * 示例 2：
 *
 * 输入：address = "255.100.50.0"
 * 输出："255[.]100[.]50[.]0"
 *
 */
public class DefangIPaddr1108 {

    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
        System.out.println(defangIPaddr("255.100.50.0"));
        System.out.println("abcdefga".replaceAll("a","s"));
    }

    public static String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}
