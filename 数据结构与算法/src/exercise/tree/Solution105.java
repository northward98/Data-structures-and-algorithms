package exercise.tree;

/**
 * leetcode.105 从前序和中序遍历序列构造二叉树
 * 给定两个整数数组 preorder 和 inorder ，
 * 其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，
 * 请构造二叉树并返回其根节点。
 */

public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int preLeft, int preRight,
                           int[] inorder, int inLeft, int inRight) {
        // 递归终止条件
        if (inLeft > inRight || preLeft > preRight) {
            return null;
        }

        // val 为前序遍历第一个的值，也即是根节点的值
        // index 为根据根节点的值来找中序遍历的下标
        int index = 0;
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        // 根据 index 来递归找左右子树
        root.left = build(preorder, preLeft + 1, preLeft + (index - inLeft),
                inorder, inLeft, index - 1);
        root.right = build(preorder, preLeft + (index - inLeft) + 1, preRight,
                inorder, index + 1, inRight);
        return root;
    }
}
