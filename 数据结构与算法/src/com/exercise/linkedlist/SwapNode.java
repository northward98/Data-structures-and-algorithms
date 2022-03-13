package com.exercise.linkedlist;

public class SwapNode {
    // 递归版本
    public ListNode swapPairs1(ListNode head) {
        // base case 退出提交
        if(head == null || head.next == null) return head;
        // 获取当前节点的下一个节点
        ListNode next = head.next;
        // 进行递归
        ListNode newNode = swapPairs1(next.next);
        // 这里进行交换
        next.next = head;
        head.next = newNode;

        return next;
    }
    // 虚拟头结点
    public ListNode swapPairs2(ListNode head) {

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prev = dummyNode;

        while (prev.next != null && prev.next.next != null) {
            ListNode temp = head.next.next; // 缓存 next
            prev.next = head.next;          // 将 prev 的 next 改为 head 的 next
            head.next.next = head;          // 将 head.next(prev.next) 的next，指向 head
            head.next = temp;               // 将head 的 next 接上缓存的temp
            prev = head;                    // 步进1位
            head = head.next;               // 步进1位
        }
        return dummyNode.next;
    }
}

