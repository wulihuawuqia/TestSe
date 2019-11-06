/**
 * 版权所有: wulihua
 * 创建日期: 2019/10/27
 * 创建作者：wuqia
 * 文件名称：RemoveOuterParentheses.java
 * 版本: 1.0
 * 修改记录:
 */
package leedcode.simple;

/**
 * Description: 删除最外层的括号.
 * @author wuqia
 * @since 2019/10/27
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 *
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 *
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 *
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * 示例 2：
 *
 * 输入："(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每隔部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * 示例 3：
 *
 * 输入："()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 *
 */
public class RemoveOuterParentheses {

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())"));
    }

    public static String removeOuterParentheses(String S) {
        StringBuffer result = new StringBuffer();
        char [] chars = S.toCharArray();
        int mark = -1;
        for (int i = 0; i < chars.length; i ++) {
            if (chars[i] == '(') {
                mark ++;
            }
            if (chars[i] == ')') {
                mark --;
            }
            if(mark == 0 && chars[i] == '(' || mark == -1 && chars[i] == ')') {
                continue;
            }
            result.append(chars[i]);
        }
        return result.toString();
    }
}
