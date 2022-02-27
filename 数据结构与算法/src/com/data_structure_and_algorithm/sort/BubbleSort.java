package com.data_structure_and_algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 冒泡排序
 */

public class BubbleSort {
    public static void main(String[] args) {
        //int[] arr = {3, 9, -1, 10, 20};
        //int[] arr = {1, 2, 3, 4, 5};

        //测试排序时间
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 80000);
        }
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是" + date1Str);

        bubbleSort(arr);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是" + date2Str);

        //System.out.println("排序后的数组");
        //System.out.println(Arrays.toString(arr));
    }

    //将冒泡排序封装成一个方法
    public static void bubbleSort(int[] arr) {
        //冒泡排序的时间复杂度，O(n^2)
        int temp = 0;//临时变量，用于交换
        boolean flag = false;//标识变量，表示是否进行过交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //如果前面数据比后面大，则交换
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if (flag == false) {
                //说明交换一次都没有发生
                break;
            } else {
                flag = false;//重置flag，用于进行下次判断
            }
        }
    }
}
