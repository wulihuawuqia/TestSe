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
 * Description:题目描述
 *
 * 把m个同样的苹果放在n个同样的盘子里，允许有的盘子空着不放，问共有多少种不同的分法？（用K表示）5，1，1和1，5，1 是同一种分法。
 *
 * 数据范围：0<=m<=10，1<=n<=10。
 * 本题含有多组样例输入。
 *
 * @author wuqia
 * @since 2020/11/10
 */
public class HJ61 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            System.out.println(count(sc.nextInt(), sc.nextInt()));
        }
        sc.close();
    }

    public static int count(int m, int n) {
        if (m < 0 || n <= 0) {
            return 0;
        }
        //细分到苹果数为一或盘子数为一的情况返回一
        if (m == 1 || n == 1 || m == 0) {
            return 1;
        }
        //将此事件无线细分
        return count(m, n - 1) + count(m - n, n);
    }
}
