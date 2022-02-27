package com.data_structure_and_algorithm.sort;

import java.util.Arrays;

/**
 * 基数排序
 */

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 542, 748, 14, 214};
        radixSort(arr);
    }

    public static void radixSort(int[] arr) {
        //得到数组中最大的数的位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();//得到位数

        //二维数组，表示10个桶
        int[][] bucket = new int[10][arr.length];
        //记录每个桶中，实际放了多少个数
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                //取出每个元素对应的位数
                int digitOfElement = arr[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                bucketElementCounts[digitOfElement]++;
            }
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据，我们才放入到数组
                if (bucketElementCounts[k] != 0) {
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        //取出元素放到arr
                        arr[index++] = bucket[k][l];
                    }
                }
                //每轮处理后，将每个bucketElementCounts = 0
                bucketElementCounts[k] = 0;
            }
            System.out.println("第" + (i + 1) + "轮后的处理结果" + Arrays.toString(arr));
        }
    }
}
