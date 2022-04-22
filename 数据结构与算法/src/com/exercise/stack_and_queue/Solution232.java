package com.exercise.stack_and_queue;

import java.util.Stack;

/**
 * leetcode.232 用栈实现队列
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 */
public class Solution232 {
    class MyQueue {

        Stack<Integer> stackIn;
        Stack<Integer> stackOut;

        public MyQueue() {
            stackIn = new Stack<>(); // 负责进栈
            stackOut = new Stack<>(); // 负责出栈
        }

        public void push(int x) {
            stackIn.push(x);
        }

        public int pop() {
            dumpStackIn();
            return stackOut.pop();
        }

        public int peek() {
            dumpStackIn();
            return stackOut.peek();
        }

        public boolean empty() {
            return stackIn.isEmpty() && stackOut.isEmpty();
        }

        // 如果stackOut为空，那么将StackIn中的元素全部放到stackOut中
        private void dumpStackIn(){
            if (!stackOut.isEmpty()) {
                return;
            }
            while (!stackIn.isEmpty()){
                stackOut.push(stackIn.pop());
            }
        }
    }
}
