package com.data_structure_and_algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序
 */

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;//左下标
        int r = right;//右下标
        int pivot = arr[(left + right) / 2];//中间的值
        int temp = 0;//交换
        //while循环的目的是让比pivot值小的放到左边
        //比pivot值大的放到右边
        while (l < r) {
            //在pivot的左边一直找，找到大于等于pivot值，才退出
            while (arr[l] < pivot) {
                l += 1;
            }
            //在pivot的右边一直找，找到小于等于pivot值，才退出
            while (arr[r] > pivot) {
                r -= 1;
            }
            //如果l >= r说明pivot的左右两边的值已经按照规定交换好
            if (l >= r) {
                break;
            }

            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            //如果交换完后，发现arr[l]==pivot值，前移
            if (arr[l] == pivot) {
                r -= 1;
            }
            //如果交换完后，发现arr[r]==pivot值，后移
            if (arr[r] == pivot) {
                l += 1;
            }
        }
        //如果l == r，必须l++，r--，否则会出现栈溢出
        if(l == r){
            l += 1;
            r -= 1;
        }
        //向左递归
        if(left < r){
            quickSort(arr,left,r);
        }
        //向右递归
        if(right > l){
            quickSort(arr,l,right);
        }
    }
}
