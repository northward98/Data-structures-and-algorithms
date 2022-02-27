package com.data_structure_and_algorithm.search;

import java.util.Arrays;

/**
 * 斐波那契查找
 */

public class FibonacciSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(fibSearch(arr,1));
    }

    //需要使用到斐波那契数列，所以要先获取到一个斐波那契狩猎
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    //方法
    public static int fibSearch(int[] a, int key) {
        //a是数组，key是要查找的值
        int low = 0;
        int high = a.length - 1;
        int k = 0;//表示斐波那契分割数列的下标
        int mid = 0;
        int[] f = fib();//获取斐波那契数列
        //获取分割数列的下标
        while (high > f[k] - 1) {
            k++;
        }
        //因为f[k]值可能大于a的长度，需要使用Arrays类，构造一个新的数组，并指向a[]
        //不足的部分会使用0填充
        int[] temp = Arrays.copyOf(a, f[k]);
        //需要使用a数组最后的数填充temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }
        //使用while循环，找到key
        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {//左边查找
                high = mid - 1;
                k--;
            } else if (key > temp[mid]) {//右边查找
                low = mid + 1;
                k -= 2;
            }else {
                if(mid <= high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
}
