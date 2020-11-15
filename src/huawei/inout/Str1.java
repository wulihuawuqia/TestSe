/**
 * 版权所有: wulihua
 * 创建日期: 2020/11/14
 * 创建作者：wuqia
 * 文件名称：Str1.java
 * 版本: 1.0
 * 修改记录:
 */
package huawei.inout;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Description: 字符排序.
 * @author wuqia
 * @since 2020/11/14
 */
public class Str1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            // String n = sc.nextLine();
            String str = sc.nextLine();
            String[] strs = str.split(",");
            Arrays.sort(strs);
            for (int i = 0; i < strs.length; i++) {
                System.out.print(strs[i]);
                if (i==strs.length-1){
                    System.out.println();
                }else {
                    System.out.print(",");
                }
            }
        }
    }
}
