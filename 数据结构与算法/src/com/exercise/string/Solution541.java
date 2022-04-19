package com.exercise.string;

/**
 * leetcode.541 反转字符串II
 * 给定一个字符串 s 和一个整数 k，
 * 你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * 示例:
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 */
public class Solution541 {
    public String reverseStr1(String s, int k) {
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i += 2 * k) {
            //如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
            //因正常情况下也是这样的反转规则，故放在一起反转
            if (i + k <= c.length) {
                reverse(c, i, i + k - 1);
                continue;
            }
            reverse(c, i, c.length - 1);
        }
        return new String(c);
    }

    public void reverse(char[] c, int start, int end) {
        for (; start < end; start++, end--) {
            char temp = c[start];
            c[start] = c[end];
            c[end] = temp;
        }
    }

    public String reverseStr2(String s, int k) {
        char[] ch = s.toCharArray();
        for(int i = 0; i < ch.length; i += 2 * k){
            int start = i;
            //这里是判断尾数够不够k个来取决end指针的位置
            int end = (ch.length - 1) < (start + k - 1) ?ch.length - 1:start + k - 1;
            //用异或运算反转
            while(start < end){
                ch[start] ^= ch[end];
                ch[end] ^= ch[start];
                ch[start] ^= ch[end];
                start++;
                end--;
            }
        }
        return new String(ch);
    }
}
