package exercise.tree;

/**
 * leetcode.106 从中序与后序遍历序列构造二叉树
 * 给定两个整数数组 inorder 和 postorder ，
 * 其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，
 * 请你构造并返回这颗 二叉树 。
 */

public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode build(int[] inorder, int inLeft, int inRight,
                               int[] postorder, int postLeft, int postRight) {
        // 没有元素了
        if (inRight - inLeft < 1) {
            return null;
        }
        // 只有一个元素了
        if (inRight - inLeft == 1) {
            return new TreeNode(inorder[inLeft]);
        }
        // 后序数组postorder里最后一个即为根结点
        int rootVal = postorder[postRight - 1];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = 0;
        // 根据根结点的值找到该值在中序数组inorder里的位置
        for (int i = inLeft; i < inRight; i++) {
            if (inorder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        // 根据rootIndex划分左右子树
        root.left = build(inorder, inLeft, rootIndex,
                postorder, postLeft, postLeft + (rootIndex - inLeft));
        root.right = build(inorder, rootIndex + 1, inRight,
                postorder, postLeft + (rootIndex - inLeft), postRight - 1);
        return root;
    }
}
