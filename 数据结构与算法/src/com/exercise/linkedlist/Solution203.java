package com.exercise.linkedlist;

/**
 * leetcode.203 移除链表元素
 * 移除链表元素
 * 删除链表中等于给定值 val 的所有节点。
 */

public class Solution203 {
    public static ListNode removeElements(ListNode head, int val) {
        //删除元素是头节点
        while (head != null && head.val == val) {
            head = head.next;
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

    //虚拟头结点方式
    public ListNode removeElements2(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        // 因为删除可能涉及到头节点，所以设置 virtual 节点，统一操作
        ListNode virtual = new ListNode(-1, head);
        ListNode pre = virtual;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return virtual.next;
    }
}

