/**
 * 版权所有: wulihua
 * 创建日期: 2020/11/14
 * 创建作者：wuqia
 * 文件名称：AB.java
 * 版本: 1.0
 * 修改记录:
 */
package huawei.inout;

import java.util.Scanner;

/**
 * Description: A+B.
 * @author wuqia
 * @since 2020/11/14
 */
public class AB3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            if (n == 0) {
                break;
            }
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += sc.nextInt();
            }
            System.out.println(count);
        }
    }
}
