package com.data_structure_and_algorithm.array.sparsearray;

/**
 * 稀疏数组的代码实现
 */

public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的二维数组
        //0表示没有棋子，1表示黑子，2表示蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][3] = 2;
        //原始的二维数组
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.print(data + "\t");
            }
            System.out.println();
        }
        //转成稀疏数组
        //1.遍历，获取非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if(chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.println("sum=" + sum);
        //2.创建稀疏数组
        int[][] sparseArray = new int[sum + 1][3];
        //3.给稀疏数组赋值
        //第一行
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;
        //遍历二维数组，将非0的值存放到稀疏数组
        int count = 0;//用于记录是第几个非0数据
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1[i].length; j++) {
                if(chessArr1[i][j] != 0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr1[i][j];
                }
            }
        }
        //输出稀疏数组
        for (int i = 0; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray[i].length; j++) {
                System.out.print(sparseArray[i][j] + "\t");
            }
            System.out.println();
        }

        //将稀疏数组恢复成二维数组
        //读取稀疏数组
        int[][] chessArr2 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            chessArr2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        //输出原始数组
        for (int i = 0; i <chessArr2.length; i++) {
            for (int j = 0; j <chessArr2[i].length ; j++) {
                System.out.print(chessArr2[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
