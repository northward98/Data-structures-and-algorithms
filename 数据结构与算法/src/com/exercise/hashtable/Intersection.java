package com.exercise.hashtable;

import java.util.HashSet;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 输出结果中的每个元素一定是唯一的。 我们可以不考虑输出结果的顺序。
 */
public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        //若任意数组为空，直接返回
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        //因为返回的数组不允许有重复元素，所以使用 Set
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> reSet = new HashSet<>();
        //遍历数组1，将数组1的元素加入到 set 中
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        //遍历数组2，判断是否有与数组1相同的元素
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])){
                reSet.add(nums2[i]);
            }
        }
        //将得到的结果保存到一个数组中
        int[] reArr = new int[reSet.size()];
        int index = 0;
        //遍历 reSet 元素，将元素添加到 reArr 中
        for (int i : reSet) {
            reArr[index++] = i;
        }
        return reArr;
    }
}
