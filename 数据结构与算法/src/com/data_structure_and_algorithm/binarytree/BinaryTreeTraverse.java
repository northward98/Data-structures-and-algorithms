package com.data_structure_and_algorithm.binarytree;

/**
 * 二叉树遍历
 */

public class BinaryTreeTraverse {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        Node root = new Node(1, "jack");
        Node node2 = new Node(2, "mike");
        Node node3 = new Node(3, "smith");
        Node node4 = new Node(4, "mary");
        Node node5 = new Node(5, "james");
        Node node6 = new Node(6, "james");

        root.setLeft(node2);
        node2.setRight(node6);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);

        binaryTree.preOrder();
        System.out.println("-------------------------");
        binaryTree.infixOrder();
        System.out.println("-------------------------");
        binaryTree.postOrder();

        binaryTree.delNode(3);
        binaryTree.preOrder();
    }
}

//定义一个二叉树
class BinaryTree {
    private Node root;//根节点

    public void setRoot(Node root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    //删除节点
    public void delNode(int no){
        if(root != null){
            if(root.getNo() == no){
                root = null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("空树，不能删除");
        }
    }
}

//创建节点
class Node {
    private int no;
    private String name;
    private Node left;//默认null
    private Node right;//默认null

    public Node(int no, String name) {
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

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);//输出父节点
        //递归向左子树
        if (this.left != null) {
            this.left.preOrder();
        }
        //递归向右子树
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序遍历
    public void infixOrder() {
        //递归向左子树
        if (this.left != null) {
            this.left.infixOrder();
        }
        //输出父节点
        System.out.println(this);
        //递归向右子树
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    //后序遍历
    public void postOrder() {
        //递归向左子树
        if (this.left != null) {
            this.left.postOrder();
        }
        //递归向右子树
        if (this.right != null) {
            this.right.postOrder();
        }
        //输出父节点
        System.out.println(this);
    }

    //删除节点
    public void delNode(int no) {
        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }
        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        //递归删除
        if (this.left != null){
            this.left.delNode(no);
        }
        if(this.right != null){
            this.right.delNode(no);
        }
    }
}