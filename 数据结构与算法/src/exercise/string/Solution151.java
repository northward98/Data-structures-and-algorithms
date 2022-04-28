package exercise.string;

/**
 * leetcode.151  翻转字符串里的单词
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * <p>
 * 示例 ：
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 */
public class Solution151 {
    //方式一:开辟新空间，空间复杂度 O(n)
    public String reverseWords1(String s) {
        char[] chars = s.toCharArray();
        char[] newArr = new char[chars.length + 1];
        int index = 0;
        //i来进行整体对源字符数组从后往前遍历
        int i = chars.length - 1;
        while (i >= 0) {
            //跳过空格
            while (i >= 0 && chars[i] == ' ') {
                i--;
            }
            //此时i位置是边界或!=空格，先记录当前索引，之后的while用来确定单词的首字母的位置
            int right = i;
            while (i >= 0 && chars[i] != ' ') {
                i--;
            }
            //指定区间单词取出(由于i为首字母的前一位，所以这里+1,)，取出的每组末尾都带有一个空格
            for (int j = i + 1; j <= right; j++) {
                newArr[index++] = chars[j];
                if (j == right) {
                    newArr[index++] = ' ';//空格
                }
            }
        }
        //若是原始字符串没有单词，直接返回空字符串；若是有单词，返回0-末尾空格索引前范围的字符数组
        if (index == 0) {
            return "";
        } else {
            return new String(newArr, 0, index - 1);
        }
    }


    //方式二
    public String reverseWords2(String s) {
        // System.out.println("ReverseWords.reverseWords2() called with: s = [" + s + "]");
        // 1.去除首尾以及中间多余空格
        StringBuilder sb = removeSpace(s);
        // 2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
        // 3.反转各个单词
        reverseEachWord(sb);
        return sb.toString();
    }

    private StringBuilder removeSpace(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (s.charAt(start) == ' ') start++;
        while (s.charAt(end) == ' ') end--;
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            char c = s.charAt(start);
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb;
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

    private void reverseEachWord(StringBuilder sb) {
        int start = 0;
        int end = 1;
        int n = sb.length();
        while (start < n) {
            while (end < n && sb.charAt(end) != ' ') {
                end++;
            }
            reverseString(sb, start, end - 1);
            start = end + 1;
            end = start + 1;
        }
    }

}
