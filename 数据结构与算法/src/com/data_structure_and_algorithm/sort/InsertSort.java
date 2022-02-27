package com.data_structure_and_algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 */

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        insertSort(arr);
    }

    public static void insertSort(int[] arr) {
        int insertValue = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            //定义插入的数
            insertValue = arr[i];
            insertIndex = i - 1;//即arr[i]的前面这个数的下标
            //insertIndex >= 0 保证在给insertValue找插入位置的时候不越界
            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            //判断是否需要赋值
            if(insertIndex + 1 != i){
                //退出while循环时，说明插入位置找到，insertIndex+1
                arr[insertIndex + 1] = insertValue;
            }
            System.out.println("第" + i + "轮插入");
            System.out.println(Arrays.toString(arr));
        }
    }
}
