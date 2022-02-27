package com.data_structure_and_algorithm.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 * 前提是数组有序
 */

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1234};
        //int resIndex = binarySearch(arr, 0, arr.length - 1, 1);
        List<Integer> resIndexList = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println(resIndexList);
    }

    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        //当left>right时，说明递归整个数组，但没找到
        if (left > right) {
            return -1;
        }

        if (findVal > midVal) {
            //向右递归
            return binarySearch(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            //向左递归
            return binarySearch(arr, left, mid - 1, findVal);
        } else {
            return mid;
        }
    }

    //优化，可以查找重复的值
    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        int mid = (left + right) / 2;
        int midVal = arr[mid];
        //当left>right时，说明递归整个数组，但没找到
        if (left > right) {
            return new ArrayList<Integer>();
        }

        if (findVal > midVal) {
            //向右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (findVal < midVal) {
            //向左递归
            return binarySearch2(arr, left, mid - 1, findVal);
        } else {
            ArrayList<Integer> resIndexList = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp -= 1;//temp左移
            }
            resIndexList.add(mid);

            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != findVal) {
                    break;
                }
                resIndexList.add(temp);
                temp += 1;
            }
            return resIndexList;
        }
    }
}
