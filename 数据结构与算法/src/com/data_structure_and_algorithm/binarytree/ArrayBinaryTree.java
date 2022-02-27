package com.data_structure_and_algorithm.binarytree;

/**
 * 顺序存储二叉树
 */

public class ArrayBinaryTree {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(0);//1 2 4 5 3 6 7
    }
}

class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //完成前序遍历
    public void preOrder(int index) {//index为数组下标
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空");
        }
        //输出当前这个元素
        System.out.println(arr[index]);
        //向左递归
        if ((index * 2 + 1) < arr.length) {
            preOrder(2 * index + 1);
        }
        //向右递归
        if ((index * 2 + 2) < arr.length) {
            preOrder(2 * index + 2);
        }
    }
}