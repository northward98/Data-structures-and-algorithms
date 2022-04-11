package com.exercise.array;

/**
 * leetcode.209 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，
 * 找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0。
 *
 * 滑动窗口法
 */

public class Solution209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        int subLength = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                subLength = (right - left + 1); // 取子序列的长度
                result = result < subLength ? result : subLength;
                sum -= nums[left];//不断变更子序列的起始位置
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
