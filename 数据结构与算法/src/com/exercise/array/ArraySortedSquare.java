package com.exercise.array;

/**
 * leetcode.977 有序数组的平方
 * 给你一个按 非递减顺序 排序的整数数组 nums，
 * 返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * 双指针法
 */

public class ArraySortedSquare {
    public static void main(String[] args) {
        int[] nums = {-4, -2, 0, 3, 10};
        int[] res = sortedSquare(nums);
        for (int i = 0; i < res.length; ++i) {
            System.out.print(res[i] + "\t");
        }
    }

    public static int[] sortedSquare(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        int[] result = new int[nums.length];
        int index = result.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index--] = nums[left] * nums[left];
                left++;
            } else {
                result[index--] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }
}
