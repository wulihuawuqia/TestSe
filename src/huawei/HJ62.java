/**
 * 版权所有: wulihua
 * 创建日期: 2020/11/14
 * 创建作者：wuqia
 * 文件名称：HJ62.java
 * 版本: 1.0
 * 修改记录:
 */
package huawei;

import java.util.Scanner;

/**
 * Description: 查找输入整数二进制中1的个数.
 * @author wuqia
 * @since 2020/11/14
 */
public class HJ62 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            Long lon = sc.nextLong();
            int count = 0;
            while (lon != 0) {
                long i = lon % 2;
                lon = lon / 2;
                if (i == 1) {
                    count ++;
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
}
