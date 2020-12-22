package niuke;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * 反转链表
 *
 * @author qia.wu
 * @create 2020-12-22 10:22
 * @see niuke
 */
public class Nc78 {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseList(ListNode head) {
        // 判断链表为空或长度为1的情况
        if (head == null || head.next == null) {
            return head;
        }
        List<ListNode> list = new ArrayList();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        ListNode pre = list.get(list.size() - 1);
        for (int i = list.size() - 2; i >= 0; i--) {
            pre.next = list.get(i);
            pre = pre.next;
        }
        pre.next = null;
        return list.get(list.size() - 1);
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;
        ListNode result = reverseList(a);
        System.err.println(result);
    }

}
