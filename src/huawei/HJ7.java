/**
 * 版权所有: wulihua
 * 创建日期: 2020/11/10
 * 创建作者：wuqia
 * 文件名称：HJ7.java
 * 版本: 1.0
 * 修改记录:
 */
package huawei;

import cn.hutool.http.webservice.SoapUtil;

import java.util.Scanner;

/**
 * Description: 取近似值.
 * @author wuqia
 * @since 2020/11/10
 */
public class HJ7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double num = in.nextDouble();
        //取整数部分
        /*int b = (int)num;
        if((num - b) >= 0.5) {
            b = (int)(num + 0.5);
        }
        System.out.println(b);*/
        System.out.println(Math.round(num));
    }
}
