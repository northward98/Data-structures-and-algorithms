package com.data_structure_and_algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序(移位式)
 * 移位式是对交换式的优化
 */

public class ShellSortMove {
    public static void main(String[] args) {
        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(arr);
    }

    public static void shellSort(int[] arr) {
        int count = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        //移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    //当退出while循环后，就给temp找到插入位置
                    arr[j] = temp;
                }

            }
            System.out.println("第" + (++count) + "轮");
            System.out.println(Arrays.toString(arr));
        }
    }
}
