/**
 * 版权所有: wulihua
 * 创建日期: 2020/11/14
 * 创建作者：wuqia
 * 文件名称：HJ66.java
 * 版本: 1.0
 * 修改记录:
 */
package huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description: 有6条配置命令，它们执行的结果分别是：.
 * 为了简化输入，方便用户，以“最短唯一匹配原则”匹配：
 * 1、若只输入一字串，则只匹配一个关键字的命令行。例如输入：r，根据该规则，匹配命令reset，执行结果为：reset what；输入：res，根据该规则，匹配命令reset，执行结果为：reset what；
 * 2、若只输入一字串，但本条命令有两个关键字，则匹配失败。例如输入：reb，可以找到命令reboot backpalne，但是该命令有两个关键词，所有匹配失败，执行结果为：unknown command
 * 3、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果仍不唯一，匹配失败。例如输入：r b，找到匹配命令reset board 和 reboot backplane，执行结果为：unkown command。
 *
 * 4、若输入两字串，则先匹配第一关键字，如果有匹配但不唯一，继续匹配第二关键字，如果唯一，匹配成功。例如输入：b a，无法确定是命令board add还是backplane abort，匹配失败。
 * 5、若输入两字串，第一关键字匹配成功，则匹配第二关键字，若无匹配，失败。例如输入：bo a，确定是命令board add，匹配成功。
 * 6、若匹配失败，打印“unknown command”
 * @author wuqia
 * @since 2020/11/14
 */
public class HJ66 {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Node> list = new ArrayList<>();
        list.add(new Node("reset", null, "reset what"));
        list.add(new Node("reset", "board", "board fault"));
        list.add(new Node("board", "add", "where to add"));
        list.add(new Node("board", "delete", "no board at all"));
        list.add(new Node("reboot", "backplane", "impossible"));
        list.add(new Node("backplane", "abort", "install first"));
        list.add(new Node("he", "he", "unknown command"));
        while(sc.hasNext()) {
            String str = sc.nextLine();
            String[] strArr = str.split(" ");
            String key1 = strArr[0];
            String key2 = null;
            if (strArr.length > 1) {
                key2 = strArr[1];
            }
            List<Node> list1 = new ArrayList<>();
            // 过滤第一个字符串
            for (Node node : list) {
                // 首先匹配第一个字符串
                if (node.getKey1().indexOf(key1) == 0) {
                    list1.add(node);
                }
            }
            List<Node> list2 = new ArrayList<>();
            if (null != key2) {
                // 过滤第二个字符串
                for (Node node : list1) {
                    if (null != node.getKey2() && node.getKey2().indexOf(key2) == 0) {
                        list2.add(node);
                    }
                }
            } else {
                for (Node node : list1) {
                    if (null == node.getKey2()) {
                        list2.add(node);
                    }
                }
            }
            if (list2.size() == 0 || list2.size() > 1) {
                System.out.println("unknown command");
            } else {
                Node node = list2.get(0);
                if (null != key2 && null == node.getKey2()) {
                    System.out.println("unknown command");
                } else {
                    System.out.println(node.getValue());
                }
            }
        }
    }

    static class Node {

        public Node(String key1, String key2, String value) {
            this.key1 = key1;
            this.key2 = key2;
            this.value = value;
        }

        private String key1;
        private String key2;
        private String value;

        public String getKey1() {
            return key1;
        }

        public void setKey1(String key1) {
            this.key1 = key1;
        }

        public String getKey2() {
            return key2;
        }

        public void setKey2(String key2) {
            this.key2 = key2;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
