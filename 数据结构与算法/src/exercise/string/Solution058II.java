package exercise.string;

/**
 * leetcode.剑指Offer58-II 左旋转字符串
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。
 *
 * 比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"。
 */

public class Solution058II {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        reverseString(sb, 0, n - 1);
        reverseString(sb, n, s.length() - 1);
        return sb.reverse().toString();
    }

    public void reverseString(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start, sb.charAt(end));
            sb.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}
