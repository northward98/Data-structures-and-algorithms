package com.exercise.linkedlist;

/**
 * leetcode.707 设计链表
 *
 */


public class Solution707 {
    //单链表
    class MyLinkedList {
        //size存储链表元素的个数
        int size;
        //虚拟头结点
        ListNode head;

        //初始化链表
        public MyLinkedList() {
            size = 0;
            head = new ListNode(0);
        }

        //获取第index个节点的数值
        public int get(int index) {
            //如果index非法，返回-1
            if (index < 0 || index >= size) {
                return -1;
            }
            ListNode currentNode = head;
            //包含一个虚拟头节点，所以查找第 index+1 个节点
            for (int i = 0; i <= index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode.val;
        }

        //在链表最前面插入一个节点
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        //在链表的最后插入一个节点
        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        // 在第 index 个节点之前插入一个新节点，例如index为0，那么新插入的节点为链表的新头节点。
        // 如果 index 等于链表的长度，则说明是新插入的节点为链表的尾结点
        // 如果 index 大于链表的长度，则返回空
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }
            if (index < 0) {
                index = 0;
            }
            size++;
            //找到要插入节点的前驱
            ListNode pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            ListNode toAdd = new ListNode(val);
            toAdd.next = pred.next;
            pred.next = toAdd;
        }

        //删除第index个节点
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }
            size--;
            ListNode pred = head;
            for (int i = 0; i < index; i++) {
                pred = pred.next;
            }
            pred.next = pred.next.next;
        }
    }

    //双链表设计
    class DesignDoubleList {
        class ListNode {
            int val;
            ListNode next,prev;
            ListNode(int x) {
                val = x;
            }
        }

        int size;
        ListNode head,tail;//Sentinel node

        public DesignDoubleList() {
            size = 0;
            head = new ListNode(0);
            tail = new ListNode(0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int index) {
            if(index < 0 || index >= size){return -1;}
            ListNode cur = head;

            // 通过判断 index < (size - 1) / 2 来决定是从头结点还是尾节点遍历，提高效率
            if(index < (size - 1) / 2){
                for(int i = 0; i <= index; i++){
                    cur = cur.next;
                }
            }else{
                cur = tail;
                for(int i = 0; i <= size - index - 1; i++){
                    cur = cur.prev;
                }
            }
            return cur.val;
        }

        public void addAtHead(int val) {
            ListNode cur = head;
            ListNode newNode = new ListNode(val);
            newNode.next = cur.next;
            cur.next.prev = newNode;
            cur.next = newNode;
            newNode.prev = cur;
            size++;
        }

        public void addAtTail(int val) {
            ListNode cur = tail;
            ListNode newNode = new ListNode(val);
            newNode.next = tail;
            newNode.prev = cur.prev;
            cur.prev.next = newNode;
            cur.prev = newNode;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if(index > size){return;}
            if(index < 0){index = 0;}
            ListNode cur = head;
            for(int i = 0; i < index; i++){
                cur = cur.next;
            }
            ListNode newNode = new ListNode(val);
            newNode.next = cur.next;
            cur.next.prev = newNode;
            newNode.prev = cur;
            cur.next = newNode;
            size++;
        }

        public void deleteAtIndex(int index) {
            if(index >= size || index < 0){return;}
            ListNode cur = head;
            for(int i = 0; i < index; i++){
                cur = cur.next;
            }
            cur.next.next.prev = cur;
            cur.next = cur.next.next;
            size--;
        }
    }
}


