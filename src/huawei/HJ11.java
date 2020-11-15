/**
 * 版权所有: wulihua
 * 创建日期: 2020/11/10
 * 创建作者：wuqia
 * 文件名称：HJ11.java
 * 版本: 1.0
 * 修改记录:
 */
package huawei;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.Scanner;

/**
 * Description: 数字颠倒.
 * @author wuqia
 * @since 2020/11/10
 */
public class HJ11 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        String numStr = String.valueOf(number);
        for (int i = numStr.length() - 1; i >= 0; i--) {
            System.out.print(numStr.charAt(i));
        }
    }
}
