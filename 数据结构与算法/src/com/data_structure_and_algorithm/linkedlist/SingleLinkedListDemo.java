package com.data_structure_and_algorithm.linkedlist;

import java.util.Stack;

/**
 * 代码实现单链表
 */

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        //创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
        //创建链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        //加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);
        //按编号加入
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);

        //显示
        singleLinkedList.list();

        //测试逆序打印
        System.out.println("逆序打印情况");
        reversePrint(singleLinkedList.getHead());
        singleLinkedList.list();

        //反转
        System.out.println("反转后的情况");
        reverseList(singleLinkedList.getHead());

        //测试修改节点
        HeroNode newHeroNode = new HeroNode(2, "卢", "玉麒麟");
        singleLinkedList.update(newHeroNode);
        //显示修改后
        System.out.println("修改后的情况");
        singleLinkedList.list();

        //删除一个节点
        singleLinkedList.del(1);
        singleLinkedList.del(4);
        System.out.println("删除后的情况");
        singleLinkedList.list();

        //有效节点
        System.out.println(getLength(singleLinkedList.getHead()));

        //倒数第k个节点
        HeroNode res = findLastIndexNode(singleLinkedList.getHead(), 1);
        System.out.println(res);
    }

    //逆序打印链表 （百度面试题）
    //方式一、先反转在打印，但此种方式会破环原链表，不建议
    //方式二、将各个节点压入到栈中，利用栈的先进后出的特点，实现逆序打印
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        //创建一个栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        //将链表的所有节点压入栈
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        //出栈
        while (stack.size() > 0){
            System.out.println(stack.pop());
        }
    }

    //将单链表翻转（腾讯面试题）
    public static void reverseList(HeroNode head) {
        //如果当前链表为空，或者只有一个节点，无需反转
        if (head.next == null || head.next.next == null) {
            return;
        }

        //定义一个辅助变量，帮助遍历原来的链表
        HeroNode cur = head.next;
        HeroNode next = null;//指向当前节点的下一个节点
        HeroNode reverseHead = new HeroNode(0, "", "");
        //遍历原来的链表，每遍历一个节点，就将其取出，放在reverseHead的最前端
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }
        //将head.next指向reverseHead.next
        head.next = reverseHead.next;
    }

    //查找单链表中的倒数第k个节点（新浪面试题）
    //1.编写一个方法，接收head节点，同时接收一个index
    //2.index表示是倒数第index个节点
    //3.先把链表从头到尾遍历，得到链表的总长度 getLength
    //4.得到size后，从链表的第一个开始遍历（size-index）个
    //5.如果找到了，就返回该节点，否则返回null
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        //第一次遍历得到节点数
        int size = getLength(head);
        //第二次遍历（size-index）位置，就是倒数第k个节点
        //先做一个index的校验
        if (index <= 0 || index > size) {
            return null;
        }
        //定义一个辅助变量
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //统计有效节点个数，即不计算头节点
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }
        int length = 0;
        //定义一个辅助变量
        HeroNode cur = head.next;
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }
}

//定义SingleLinkedList管理
class SingleLinkedList {
    //初始化一个头节点，头节点不要动,头节点不存放具体数据
    private HeroNode head = new HeroNode(0, "", "");

    //返回头节点
    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //当不考虑编号顺序时
    //1.找到当前链表的最后节点
    //2.将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode) {
        //因为头节点不能动，所以需要一个辅助变量
        HeroNode tmp = head;
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
    }

    //第二种添加方式，按排名添加
    //如果有这个排名，则添加失败，并给出提示
    public void addByOrder(HeroNode heroNode) {
        //因为头节点不能动，所以需要一个辅助变量
        //因为是单链表，所以我们找的temp是位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        boolean flag = false;//标志添加的编号是否存在，默认为false
        while (true) {
            if (temp.next == null) {
                //说明temp已经在链表的最后
                break;
            }
            if (temp.next.no > heroNode.no) {
                //位置找到
                break;
            } else if (temp.next.no == heroNode.no) {
                //说明添加的编号已经存在
                flag = true;
                break;
            }
            temp = temp.next;//后移
        }
        //判断flag的值
        if (flag) {
            //说明此时不能添加
            System.out.println("插入的英雄编号" + heroNode.no + "已经存在");
        } else {
            //此时可以插入到temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点信息，根据no编号修改，即no编号不能改
    public void update(HeroNode newHeroNode) {
        //判断是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到需要修改的节点，根据no编写
        HeroNode temp = head.next;
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
        HeroNode temp = head;
        boolean flag = false;//标志是否找到待删除节点
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                //找到了待删除节点的前一个结点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {//可以删除
            temp.next = temp.next.next;
        } else {
            System.out.println("要删除的节点" + no + "不存在");
        }
    }

    //显示链表
    public void list() {
        //先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点不能动，所以需要一个辅助变量
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }
}

//定义一个HeroNode，每个HeroNode对象就是一个节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;//指向下一个节点

    //构造器
    public HeroNode(int no, String name, String nickname) {
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