package exercise.stack_and_queue;

/**
 * leetcode.1047 删除字符串中的所有相邻重复项
 *
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * 示例：
 * 输入："abbaca"
 * 输出："ca"
 */

public class Solution1047 {
    //方式一
    public String removeDuplicates1(String s) {
        StringBuilder sb = new StringBuilder();
        //len 为 sb 的长度
        int len = -1;
        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            if(len >= 0 && sb.charAt(len) == c){
                sb.deleteCharAt(len);
                len--;
            }else{
                sb.append(c);
                len++;
            }
        }

        return sb.toString();
    }

    //方式二，速度最快
    public String removeDuplicates(String s) {
        char[] ch = s.toCharArray();
        int fast = 0;
        int slow = 0;
        while(fast < s.length()){
            // 直接用fast指针覆盖slow指针的值
            ch[slow] = ch[fast];
            // 遇到前后相同值的，就跳过，即slow指针后退一步，下次循环就可以直接被覆盖掉了
            if(slow > 0 && ch[slow] == ch[slow - 1]){
                slow--;
            }else{
                slow++;
            }
            fast++;
        }
        return new String(ch,0,slow);
    }
}
