package com.data_structure_and_algorithm.binarytree;

/**
 * 二叉树查找
 */

public class BinaryTreeSearch {
    public static void main(String[] args) {
        BinaryTree1 binaryTree = new BinaryTree1();
        Node1 root = new Node1(1, "jack");
        Node1 node2 = new Node1(2, "mike");
        Node1 node3 = new Node1(3, "smith");
        Node1 node4 = new Node1(4, "mary");
        Node1 node5 = new Node1(5, "james");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setLeft(node5);
        node3.setRight(node4);
        binaryTree.setRoot(root);

        System.out.println(binaryTree.preSearch(5));
        System.out.println(binaryTree.infixSearch(5));
        System.out.println(binaryTree.postSearch(5));

    }
}

//定义一个二叉树
class BinaryTree1 {
    private Node1 root;//根节点

    public void setRoot(Node1 root) {
        this.root = root;
    }

    public Node1 preSearch(int no){
        if(this.root != null){
            return this.root.preSearch(no);
        }else {
            return null;
        }
    }
    public Node1 infixSearch(int no){
        if(this.root != null){
            return this.root.infixSearch(no);
        }else {
            return null;
        }
    }
    public Node1 postSearch(int no){
        if(this.root != null){
            return this.root.postSearch(no);
        }else {
            return null;
        }
    }

}

//创建节点
class Node1 {
    private int no;
    private String name;
    private Node1 left;//默认null
    private Node1 right;//默认null

    public Node1(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node1 getLeft() {
        return left;
    }

    public void setLeft(Node1 left) {
        this.left = left;
    }

    public Node1 getRight() {
        return right;
    }

    public void setRight(Node1 right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node1{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序查找
    public Node1 preSearch(int no){
        if(this.no == no){
            return this;
        }
        Node1 resNode = null;
        if(this.left != null){
            resNode = this.left.preSearch(no);
        }
        if(resNode != null){//说明找到了
            return resNode;
        }
        if(this.right != null){
            resNode = this.right.preSearch(no);
        }
        return resNode;
    }

    //中序遍历
    public Node1 infixSearch(int no){
        Node1 resNode = null;
        if(this.left != null){
            resNode = this.left.infixSearch(no);
        }
        if(resNode != null){//说明找到了
            return resNode;
        }
        if(this.no == no){
            return this;
        }
        if(this.right != null){
            resNode = this.right.infixSearch(no);
        }
        return resNode;
    }

    //后序查找
    public Node1 postSearch(int no){
        Node1 resNode = null;
        if(this.left != null){
            resNode = this.left.postSearch(no);
        }
        if(resNode != null){//说明找到了
            return resNode;
        }
        if(this.right != null){
            resNode = this.right.postSearch(no);
        }
        if(resNode != null){//说明找到了
            return resNode;
        }
        if(this.no == no){
            return this;
        }
        return resNode;
    }
}