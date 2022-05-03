package exercise.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode.104 二叉树的最大深度
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 */

public class Solution104 {
    public int maxDepth(TreeNode root) {
        if (root == null)  {
            return 0;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int depth = 0;
        while (!que.isEmpty()) {
            int len = que.size();
            for(int i = 0;i < len;i++) {
                TreeNode node = que.poll();
                if (node.left != null)  {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
