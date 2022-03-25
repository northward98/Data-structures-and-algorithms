package com.exercise.hashtable;

import java.util.HashMap;

/**
 * 给定一个整数数组 nums 和一个目标值 target，
 * 请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            //查找键是否存在
            if (map.containsKey(temp)) {
                res[0] = map.get(temp);
                res[1] = i;
            }
            //不重复的话，key保存数值，value保存数值下标
            map.put(nums[i], i);
        }
        return res;
    }
}
