package com.data_structure_and_algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 从小到大排序
 */

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];//重置min
                    minIndex = j;//重置minIndex
                }
            }

            //将最小值放在arr[0]
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
            System.out.println("第" + (i + 1) + "轮后");
            System.out.println(Arrays.toString(arr));
        }
    }
}
