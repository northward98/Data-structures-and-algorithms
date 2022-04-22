package com.exercise.stack_and_queue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode.225 队列实现栈
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 */
public class Solution225 {
    //使用两个 Queue 实现
    class MyStack1 {

        Queue<Integer> queue1; // 和栈中保持一样元素的队列
        Queue<Integer> queue2; // 辅助队列，把que1最后面的元素以外的元素都备份到que2

        public MyStack1() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void push(int x) {
            queue2.offer(x); // 先放在辅助队列中
            while (!queue1.isEmpty()){
                queue2.offer(queue1.poll());
            }
            Queue<Integer> queueTemp;
            queueTemp = queue1;
            queue1 = queue2;
            queue2 = queueTemp; // 最后交换queue1和queue2，将元素都放到queue1中
        }

        public int pop() {
            return queue1.poll(); // 因为queue1中的元素和栈中的保持一致，所以这个和下面两个的操作只看queue1即可
        }

        public int top() {
            return queue1.peek();
        }

        public boolean empty() {
            return queue1.isEmpty();
        }
    }

    //使用两个 Deque 实现
    class MyStack2 {
        // Deque 接口继承了 Queue 接口
        // 所以 Queue 中的 add、poll、peek等效于 Deque 中的 addLast、pollFirst、peekFirst
        Deque<Integer> que1; // 和栈中保持一样元素的队列
        Deque<Integer> que2; // 辅助队列

        public MyStack2() {
            que1 = new ArrayDeque<>();
            que2 = new ArrayDeque<>();
        }

        public void push(int x) {
            que1.addLast(x);
        }

        public int pop() {
            int size = que1.size();
            size--;
            // 将 que1 导入 que2 ，但留下最后一个值
            while (size-- > 0) {
                que2.addLast(que1.peekFirst());
                que1.pollFirst();
            }

            int res = que1.pollFirst();
            // 将 que2 对象的引用赋给了 que1 ，此时 que1，que2 指向同一个队列
            que1 = que2;
            // 如果直接操作 que2，que1 也会受到影响，所以为 que2 分配一个新的空间
            que2 = new ArrayDeque<>();
            return res;
        }

        public int top() {
            return que1.peekLast();
        }

        public boolean empty() {
            return que1.isEmpty();
        }
    }

    //优化，使用一个 Deque 实现
    class MyStack3 {
        // Deque 接口继承了 Queue 接口
        // 所以 Queue 中的 add、poll、peek等效于 Deque 中的 addLast、pollFirst、peekFirst
        Deque<Integer> que1;
        public MyStack3() {
            que1 = new ArrayDeque<>();
        }

        public void push(int x) {
            que1.addLast(x);
        }

        
        public int pop() {
            int size = que1.size();
            size--;

            while (size-- > 0) {
                que1.addLast(que1.peekFirst());
                que1.pollFirst();
            }

            int res = que1.pollFirst();
            return res;
        }

        public int top() {
            return que1.peekLast();
        }

        public boolean empty() {
            return que1.isEmpty();
        }
    }
}
