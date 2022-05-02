package exercise.array;

/**
 * leetcode.704 二分查找
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target，
 * 写一个函数搜索 nums 中的 target，
 * 如果目标值存在返回下标，否则返回 -1。
 *
 * 前提是数组为有序数组，同时还强调数组中无重复元素，
 * 因为一旦有重复元素，使用二分查找法返回的元素下标可能不是唯一的，
 * 当看到题目描述满足如上条件的时候，可以想一想是不是用二分法了。
 */

public class Solution704 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 7, 9, 10};
        System.out.println(search1(nums, 10));//6
        System.out.println(search2(nums, 9));//5
        System.out.println(search2(nums, 10));//-1
    }

    //方法一：左闭右闭，target 是在一个在左闭右闭的区间里，也就是[left, right]
    public static int search1(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    //方法二：左闭右开,target 是在一个在左闭右开的区间里，也就是[left, right)，
    //即采用第二种方法查找10是找不到的
    public static int search2(int[] nums, int target) {
        // 避免当 target 小于nums[0] nums[nums.length - 1]时多次循环运算
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);//left + (right - left) / 2
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        return -1;
    }
}



