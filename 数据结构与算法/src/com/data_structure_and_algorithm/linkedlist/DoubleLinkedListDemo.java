package com.data_structure_and_algorithm.linkedlist;

/**
 * 双向链表
 */

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        //添加
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();

        //修改
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.update(newHeroNode);
        System.out.println("修改后情况");
        doubleLinkedList.list();

        //删除
        doubleLinkedList.del(3);
        System.out.println("删除后的情况");
        doubleLinkedList.list();
    }
}

//创建一个双向链表的类
class DoubleLinkedList {
    //初始化一个头节点，头节点不要动,头节点不存放具体数据
    private HeroNode2 head = new HeroNode2(0, "", "");

    //返回头节点
    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表的方法
    //显示链表
    public void list() {
        //先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，所以需要一个辅助变量
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }
    //添加
    public void add(HeroNode2 heroNode) {
        //因为头节点不能动，所以需要一个辅助变量
        HeroNode2 tmp = head;
        //遍历链表，找到最后
        while (true) {
            if (tmp.next == null) {
                break;
            }
            //如果没有找到，就将tmp后移
            tmp = tmp.next;
        }
        //当退出while循环时，tmp就指向了链表的最后
        //将最后这个节点的next指向新的节点
        tmp.next = heroNode;
        heroNode.pre = tmp;
    }

    //修改
    public void update(HeroNode2 newHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编写
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;//已经遍历完链表
            }
            if (temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        //根据flag判断是否找到要修改的节点
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            //没有找到
            System.out.println("没有找到编号为" + newHeroNode.no + "的节点，不能修改");
        }
    }

    //删除节点
    public void del(int no) {
        //判断当前链表是否为空
        if(head.next == null){
            System.out.println("链表为空，无法删除");
            return;
        }

        HeroNode2 temp = head;
        boolean flag = false;//标志是否找到待删除节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.no == no) {
                //找到了待删除节点的前一个结点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {//可以删除
            temp.pre.next = temp.next;
            //如果是最后一个节点 ，就不需要执行下面这句话，否则会出异常，出现空指针
            if (temp.next != null){
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("要删除的节点" + no + "不存在");
        }
    }

}

class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;//指向下一个节点
    public HeroNode2 pre;//指向前一个节点

    //构造器
    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    //为了显示方便，重写toString方法

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}