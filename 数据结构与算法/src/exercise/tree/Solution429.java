package exercise.tree;

import java.util.*;

/**
 * leetcode.429 N叉树的层序遍历
 */

public class Solution429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        if (root == null) {
            return list;
        }

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelList = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node temp = queue.poll();

                levelList.add(temp.val);

                List<Node> children = temp.children;
                if (children == null || children.size() == 0) {
                    continue;
                }
                for (Node child : children) {
                    if (child != null) {
                        queue.offer(child);
                    }
                }
            }
            list.add(levelList);
        }

        return list;
    }
}
