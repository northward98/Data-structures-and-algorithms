package com.data_structure_and_algorithm.linkedlist;

/**
 * 演示环形单链表
 * 约瑟夫问题
 */

public class Josephu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);//加入5个节点
        circleSingleLinkedList.show();

        //出圈
        circleSingleLinkedList.countBoy(1, 2, 5);
    }
}

//创建环形单向链表
class CircleSingleLinkedList {
    //创建一个first节点
    private Boy first = null;

    //添加节点，构建成环形链表
    public void addBoy(int nums) {
        //nums校验
        if (nums < 1) {
            System.out.println("nums值不正确");
            return;
        }
        Boy curBoy = null;//辅助变量
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            //如果是第一个
            if (i == 1) {
                first = boy;
                first.setNext(first);//构成环形
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //遍历当前的环形链表
    public void show() {
        //判断链表是否为空
        if (first == null) {
            System.out.println("链表为空");
            return;
        }
        Boy curBoy = first;
        while (true) {
            System.out.println("编号" + curBoy.getNo());
            if (curBoy.getNext() == first) {
                //说明遍历完毕
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    //根据输入，计算出圈顺序  startNo表示从几号开始，countNum表示数几下，nums表示最初有多少人在圈中
    public void countBoy(int startNo, int countNum, int nums) {
        //先校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数错误");
        }
        //创建辅助指针，帮助完成出圈
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                //说明helper指向最后节点
                break;
            }
            helper = helper.getNext();
        }
        //报数前，让first和helper移动k-1次
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }
        //报数时，让first和helper指针同时移动m-1次，然后出圈
        //循环操作，直到圈中只有一个节点
        while (true) {
            if (helper == first) {
                //说明圈中只有一个节点
                break;
            }
            //让first和helper同时移动
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            System.out.println("编号" + first.getNo() + "出圈");
            //这时将first指向节点出圈
            first = first.getNext();
            helper.setNext(first);
        }
        System.out.println("最终留在圈中的编号是" + first.getNo());
    }
}

//创建一个Boy类，表示一个节点
class Boy {
    private int no;//编号
    private Boy next;//指向下一个节点

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}