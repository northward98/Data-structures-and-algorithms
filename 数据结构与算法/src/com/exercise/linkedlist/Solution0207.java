package com.exercise.linkedlist;

/**
 * leetcode.面试题 02.07 链表相交
 * 链表相交
 * 给你两个单链表的头节点 headA 和 headB ，
 * 找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null
 */

public class Solution0207 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0;
        int lenB = 0;
        while (curA != null) {//链表A的长度
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {//链表B的长度
            lenB++;
            curB = curB.next;
        }
        //重新恢复头节点
        curA = headA;
        curB = headB;

        // 因为无法确定A与B的长度，使得后续尾部对齐有障碍，所以
        // 让curA为最长链表的头，lenA为其长度
        if (lenB > lenA) {
            //1. swap (lenA, lenB);
            int tmpLen = lenA;
            lenA = lenB;
            lenB = tmpLen;
            //2. swap (curA, curB);
            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }
        // 求长度差
        int gap = lenA - lenB;
        // 让curA和curB在同一起点上（末尾位置对齐）
        while (gap-- > 0) {
            curA = curA.next;
        }
        // 遍历curA 和 curB，遇到相同则直接返回
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
