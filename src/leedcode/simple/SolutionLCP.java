/**
 * 版权所有: wulihua
 * 创建日期: 2019/10/19
 * 创建作者：wuqia
 * 文件名称：SolutionLCP.java
 * 版本: 1.0
 * 修改记录:
 */
package leedcode.simple;

import extend.A;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 猜数字.
 * @author wuqia
 * @since 2019/10/19
 */
public class SolutionLCP {

    public int game(int[] guess, int[] answer) {
        int a = 0;
        for (int i = 0; i < 3; i++) {
            if(guess[i] == answer[i]) {
                a ++;
            }
        }
        return a;
    }

    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for (char s : S.toCharArray()) {
            for (char j : J.toCharArray()) {
                if(s == j) {
                    count ++;
                }
            }
        }
        return count;
    }

    public String longestWord(String[] words) {
        String result = "";
        List<String> reList = new ArrayList<>();

        return result;
    }
}
