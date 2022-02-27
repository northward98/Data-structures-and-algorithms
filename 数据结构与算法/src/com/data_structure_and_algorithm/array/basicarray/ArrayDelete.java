package com.data_structure_and_algorithm.array.basicarray;

/**
 * 数组元素删除
 */

public class ArrayDelete {
    public static void main(String[] args) throws Exception {
        MyArray myArray = new MyArray(3);
        myArray.insert(1, 0);
        myArray.insert(5, 1);
        myArray.insert(4, 2);
        myArray.insert(3, 3);
        myArray.insert(3, 4);
        myArray.insert(7, 5);
        myArray.show();
        myArray.delete(3);
        myArray.show();
    }
}

class MyArray {
    private int[] arr;
    private int size;

    public MyArray(int capacity) {
        this.arr = new int[capacity];
        size = 0;
    }

    //数组删除
    public int delete(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("超出数组范围");
        }
        int delElement = arr[index];
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        return delElement;
    }

    //数组扩容
    public void resize() {
        int[] arrNew = new int[arr.length * 2];
        //数组拷贝
        System.arraycopy(arr, 0, arrNew, 0, arr.length);
        arr = arrNew;
    }

    //插入元素
    public void insert(int elements, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new Exception("超出数组范围");
        }

        if (size >= arr.length) {
            resize();
        }

        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }

        arr[index] = elements;
        size++;
    }

    //输出数组
    public void show() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}
