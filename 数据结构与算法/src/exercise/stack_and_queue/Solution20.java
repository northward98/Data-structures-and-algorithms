package exercise.stack_and_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * leetcode.20 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */

public class Solution20 {
    //方式一
    public boolean isValid1(String s) {
        if(s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for(char c:s.toCharArray()){
            if(c=='('){
                stack.push(')');
            }else if(c=='{'){
                stack.push('}');
            }else if(c=='['){
                stack.push(']');
            }else if(stack.empty()||c!=stack.pop()){
                return false;
            }
        }
        if(stack.empty()){
            return true;

        }
        return false;
    }
    //方式二
    public boolean isValid2(String s) {
        Deque<Character> deque = new LinkedList<>();
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            //碰到左括号，就把相应的右括号入栈
            if (ch == '(') {
                deque.push(')');
            }else if (ch == '{') {
                deque.push('}');
            }else if (ch == '[') {
                deque.push(']');
            }else if (deque.isEmpty() || deque.peek() != ch) {
                return false;
            }else {//如果是右括号判断是否和栈顶元素匹配
                deque.pop();
            }
        }
        //最后判断栈中元素是否匹配
        return deque.isEmpty();
    }
}
