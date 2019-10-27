/**
 * 版权所有: wulihua
 * 创建日期: 2019/10/19
 * 创建作者：wuqia
 * 文件名称：Solution720.java
 * 版本: 1.0
 * 修改记录:
 */
package leedcode.simple;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xml.internal.utils.Trie;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Description: 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。  来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。.
 * @author wuqia
 * @since 2019/10/19
 */
public class Solution720 {

    public static void main(String[] args) {
        String[] words = new String[]{"apple1","a", "banana", "appl", "app",  "ap", "apply1"};
        System.out.println(longestWord(words));
    }

    public static String longestWord(String[] words) {
        String res = "";
        //字典排序
        Arrays.sort(words);
        System.out.println(JSON.toJSON(words));
        HashSet<String> hashSet = new HashSet<>();
        for (String s : words) {
            // System.out.println(s.substring(0, s.length() - 1));
            // 如果首字母包含则加入库
            if (s.length() == 1 || hashSet.contains(s.substring(0, s.length() - 1))) {
                System.out.println(s.substring(0, s.length() - 1));
                res = s.length() > res.length() ? s : res;
                hashSet.add(s);
            }
        }
        return res;
    }

    class TrieNode{
        public char data;
        public boolean isword = false;
        public TrieNode[] next = new TrieNode[26];
        public TrieNode(char c){
            data = c;
        }
    }


    class Trie{
        TrieNode root = new TrieNode('/');

        public void insert(String string){             //用来插入一个string
            char[] ccc = string.toCharArray();
            TrieNode p = root;
            for(int i=0; i<ccc.length; i++){
                int index = ccc[i] - 'a';
                if(p.next[index] == null){
                    TrieNode trienode = new TrieNode(ccc[i]);
                    p.next[index] = trienode;
                }
                p = p.next[index];
            }
            p.isword = true;
        }

        public boolean isBuild(String string){            //用来判断这个字符串是不是由其他节点依次加一个字符组成
            char[] ccc = string.toCharArray();
            TrieNode p = root;
            for(int i=0; i<ccc.length; i++){
                if(!p.next[ccc[i]-'a'].isword) return false;
                p = p.next[ccc[i]-'a'];
            }
            return true;
        }

    }


    class Solution {
        String longestword = "";
        int longlen = 0;
        public String longestWord(String[] words) {
            Trie trie = new Trie();

            for(String word: words){                                     //依次插入string
                trie.insert(word);
            }

            for(String word: words){
                if(trie.isBuild(word) && word.length() > longlen){         //遍历后发现有更长的string满足条件，进行替换
                    longestword = word;
                    longlen = word.length();
                }else if(trie.isBuild(word) && word.length() == longlen){     //当出现一样长的字符串时，进行比较
                    char[] longestchar = longestword.toCharArray();
                    char[] wordchar = word.toCharArray();
                    for(int i=0; i<longlen; i++){
                        if(wordchar[i]-longestchar[i] < 0){
                            longestword = word;
                            break;
                        }else if(wordchar[i]-longestchar[i] > 0) break;
                    }
                }
            }
            return longestword;

        }
    }

}
