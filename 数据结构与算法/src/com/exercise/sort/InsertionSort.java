package com.exercise.sort;

/**
 * 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {2, 5, 4, 1, 3, 6};
        System.out.println("排序前");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

        System.out.println();

        insertionSort(arr);
        System.out.println("排序后");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insert = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > insert) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = insert;
        }
    }
}
