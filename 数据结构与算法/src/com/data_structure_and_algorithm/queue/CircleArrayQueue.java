package com.data_structure_and_algorithm.queue;

import java.util.Scanner;

/**
 * 对数组实现队列的优化
 * 使用环形队列
 */

public class CircleArrayQueue {
    public static void main(String[] args) {
        //创建一个环形队列
        CircleArray circleArray = new CircleArray(4);//设置4，其队列的有效数据最大是3,预留了一个空间
        char key = ' ';//接受用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取出数据");
            System.out.println("h(head)：查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    circleArray.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    circleArray.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = circleArray.getQueue();
                        System.out.println("取出的数据是" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int res = circleArray.headQueue();
                        System.out.println("队列头的数据是" + res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
    }
}

//使用数组模拟队列编写一个ArrayQueue类
class CircleArray {
    private int maxSize;//表示数组的最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr;//该数组用于存放数据，模拟队列

    //创建队列构造器
    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        //此处不写也行，因为int默认值就是0
        front = 0;//指向队列头部前一个位置
        rear = 0;//指向队尾
    }

    //判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列已满，不能加入数据");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //将rear后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }

    //获取队列数据，出队列
    public int getQueue() {
        //判断队列是否空
        if (isEmpty()) {
            //通过抛异常处理
            throw new RuntimeException("队列空，不能取数据");
        }
        //front指向第一个元素
        //1.先将front对应的值保留到一个临时变量
        //2.将front后移,考虑取模
        //3.将临时保存的变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列的所有数据
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.print("arr[" + i % maxSize + "]=" + arr[i % maxSize] + "\t");
        }
        System.out.println();
    }

    //添加一个当前队列有效数据的个数
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头部数据，注意不是取出数据
    public int headQueue() {
        //判断
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front];
    }
}
