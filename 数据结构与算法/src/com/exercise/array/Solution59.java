package com.exercise.array;

/**
 * leetcode.59 螺旋矩阵II
 * 给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，
 * 且元素按顺时针顺序螺旋排列的正方形矩阵。
 */

public class Solution59 {
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        //循环次数
        int loop = n / 2;
        //定义起始位置
        int startX = 0;
        int startY = 0;
        //定义偏移量
        int set = 1;
        //定义填充数字
        int count = 1;
        //定义中间位置
        int mid = n / 2;

        while (loop > 0) {
            int i = startX;
            int j = startY;
            //左闭右开原则
            // 模拟上侧从左到右
            for (; j < startY + n - set; ++j) {
                res[startX][j] = count++;
            }
            // 模拟右侧从上到下
            for (; i < startX + n - set; ++i) {
                res[i][j] = count++;
            }
            // 模拟下侧从右到左
            for (; j > startY; j--) {
                res[i][j] = count++;
            }
            // 模拟左侧从下到上
            for (; i > startX; i--) {
                res[i][j] = count++;
            }
            loop--;
            startX += 1;
            startY += 1;
            set += 2;
        }

        if (n % 2 == 1) {
            res[mid][mid] = count;
        }

        return res;
    }
}
