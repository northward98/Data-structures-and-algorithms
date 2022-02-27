package com.data_structure_and_algorithm.hashtable;

import java.util.Scanner;

/**
 * 演示哈希表
 */

public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(7);

        //编写一个菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("add：添加雇员");
            System.out.println("list：显示雇员");
            System.out.println("find：查找雇员");
            System.out.println("exit：退出系统");

            key = scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建雇员
                    Emp emp = new Emp(id,name);
                    hashTable.add(emp);
                    break;
                case "list":
                    hashTable.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTable.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }

    }
}

//创建哈希表
class HashTable {
    private EmpLinkedList[] empLinkedListArray;//存放链表的数组
    private int size;//表示有多少条链表

    public HashTable(int size) {
        this.size = size;
        //初始化
        empLinkedListArray = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp) {
        //根据员工的id，得到该员工应该添加到哪条链表
        int empLinkedListNo = hashFun(emp.id);
        //将emp添加到对应的链表中
        empLinkedListArray[empLinkedListNo].add(emp);
    }

    //编写散列函数
    public int hashFun(int id) {
        return id % size;
    }

    //根据id查找雇员
    public void findEmpById(int id){
        int empLinkedListNo = hashFun(id);
        Emp emp = empLinkedListArray[empLinkedListNo].findEmpById(id);
        if(emp != null){
            //找到
            System.out.println("在第" + (empLinkedListNo + 1) +"条找到该雇员，雇员id=" + id);
        }else {
            System.out.println("没找到");
        }
    }

    //遍历所有的链表
    public void list(){
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i);
        }
    }
}

//表示一个雇员
class Emp {
    public int id;
    public String name;
    public Emp next;//next默认为空

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}

//创建一个EmpLinkedList，表示链表
class EmpLinkedList {
    //头指针，执行第一个Emp
    private Emp head;//默认为null

    //添加雇员到链表
    public void add(Emp emp) {
        //如果是第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        //如果不是第一个雇员
        Emp curEmp = head;//辅助指针
        while (true) {
            if (curEmp.next == null) {//说明到最后
                break;
            }
            curEmp = curEmp.next;//后移
        }

        //退出时直接将emp加入链表
        curEmp.next = emp;
    }

    //遍历链表的雇员信息
    public void list(int no) {
        if (head == null) {
            System.out.println("第" + (no+1) + "条链表为空");
            return;
        }
        System.out.print("第" + (no + 1) + "条链表信息为");
        Emp curEmp = head;//辅助指针
        while (true) {
            System.out.print( " => "+ curEmp.id + " " + curEmp.name);
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    //根据id查找雇员
    public Emp findEmpById(int id){
        //判断链表是否为空
        if(head == null){
            System.out.println("链表为空");
            return null;
        }
        //辅助指针
        Emp curEmp = head;
        while (true){
            if(curEmp.id == id){//找到
                break;
            }
            if(curEmp.next == null){//说明没找到
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}