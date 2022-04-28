package exercise.linkedlist;

/**
 * leetcode.876 链表的中间节点
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 */

public class Solution876 {
    public ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            len++;
        }
        int pos = len / 2;
        ListNode cur = head;
        while(pos > 0){
            cur = cur.next;
            pos--;
        }
        return cur;
    }
}
