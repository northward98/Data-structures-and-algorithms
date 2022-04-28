package exercise.linkedlist;

/**
 * leetcode.206  反转链表
 * 反转链表
 * 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
 */

public class Solution206 {
    //双指针法
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode temp = null;
        while (cur != null) {
            temp = cur.next;// 保存下一个节点
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
}
