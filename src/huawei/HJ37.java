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
 * Description: .
 * @author wuqia 输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。
 * 这个数转换成2进制后，输出1的个数
 * @since 2020/11/10
 */
public class HJ37 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()) {
            int num = in.nextInt();
            if(num == 0) {
                break;
            }
            System.out.println(getResult(num));
        }
    }

    public static int getResult(int num) {
        if (num == 1 || num == 2) {
            return 1;
        } else {
            return getResult(num-1) + getResult(num-2);
        }
    }
}
