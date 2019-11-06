/**
 * 版权所有: wulihua
 * 创建日期: 2019/10/27
 * 创建作者：wuqia
 * 文件名称：BalancedStringSplit1221.java
 * 版本: 1.0
 * 修改记录:
 */
package leedcode.simple;

import com.alibaba.druid.sql.visitor.functions.Char;

/**
 * Description: 分割平衡字符.
 * @author wuqia
 * @since 2019/10/27
 * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
 *
 * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 *
 * 返回可以通过分割得到的平衡字符串的最大数量。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * 解释：s 可以分割为 "RL", "RRLL", "RL", "RL", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 * 示例 2：
 *
 * 输入：s = "RLLLLRRRLR"
 * 输出：3
 * 解释：s 可以分割为 "RL", "LLLRRR", "LR", 每个子字符串中都包含相同数量的 'L' 和 'R'。
 * 示例 3：
 *
 * 输入：s = "LLLLRRRR"
 * 输出：1
 * 解释：s 只能保持原样 "LLLLRRRR".
 */
public class BalancedStringSplit1221 {

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));

        System.out.println(balancedStringSplit("RLLLLRRRLR"));

        System.out.println(balancedStringSplit("LLLLRRRR"));
    }

    public static int balancedStringSplit(String s) {
        int count = 0;
        int Lcount = 0;
        int Rcount = 0;
        for(char c : s.toCharArray()){
            if (c == 'L') {
                Lcount ++;
            } else {
                Rcount ++;
            }
            if (Lcount == Rcount) {
                count ++;
                Lcount = 0;
                Rcount = 0;
            }
        }
        return count;
    }
}
