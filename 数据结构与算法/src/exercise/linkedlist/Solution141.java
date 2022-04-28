package exercise.linkedlist;

/**
 * leetcode.141 环形链表
 * 给你一个链表的头节点 head ，判断链表中是否有环。
 * 如果链表中存在环 ，则返回 true 。 否则，返回 false
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {// 有环
                return true;
            }
        }
        return false;
    }
}
