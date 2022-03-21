package com.exercise.linkedlist;

/**
 * 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 */

public class RemoveElement {
    public static ListNode removeElements(ListNode head, int val) {
        //删除元素是头节点
        while (head != null && head.val == val) {
            head.next = head;
        }
        //若头结点为空，提前结束
        if (head == null) {
            return head;
        }
        // 已确定当前head.val != val
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}

