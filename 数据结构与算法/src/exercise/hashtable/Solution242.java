package exercise.hashtable;

/**
 * leetcode.242 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 示例 1: 输入: s = "anagram", t = "nagaram" 输出: true
 * 示例 2: 输入: s = "rat", t = "car" 输出: false
 *
 * 说明: 你可以假设字符串只包含小写字母。
 */

public class Solution242 {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length ; i++) {
            record[chars[i] - 'a'] += 1;
        }
        char[] chart = t.toCharArray();
        for (int i = 0; i < chart.length; i++) {
            record[chart[i] - 'a'] -= 1;
        }
        for (int i = 0; i < record.length; i++) {
            if(record[i] != 0){
                return false;
            }
        }
        return true;
    }
}
