/**
 * 版权所有: wulihua
 * 创建日期: 2020/11/10
 * 创建作者：wuqia
 * 文件名称：HJ7.java
 * 版本: 1.0
 * 修改记录:
 */
package huawei;

import java.util.Scanner;

/**
 * Description: 取近似值.
 *
 * @author wuqia
 * @since 2020/11/10
 * 完全数（Perfect number），又称完美数或完备数，是一些特殊的自然数。
 * <p>
 * 它所有的真因子（即除了自身以外的约数）的和（即因子函数），恰好等于它本身。
 * <p>
 * 例如：28，它有约数1、2、4、7、14、28，除去它本身28外，其余5个数相加，1+2+4+7+14=28。s
 * <p>
 * 输入n，请输出n以内(含n)完全数的个数。计算范围, 0 < n <= 500000
 * <p>
 * <p>
 * 本题输入含有多组样例。
 */
public class HJ56 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int count = 0;
            for (int i = 2; i <= a; i++) {
                if (calc(i)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    public static boolean calc(int num) {
        int sum = 0;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }
        if (sum + 1 == num) {
            return true;
        }
        return false;
    }
}
