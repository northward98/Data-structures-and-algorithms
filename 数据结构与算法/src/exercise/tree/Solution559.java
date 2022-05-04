package exercise.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * leetcode.559 N叉树的最大深度
 */
public class Solution559 {
    //递归法
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        if (root.children != null){
            for (Node child : root.children){
                depth = Math.max(depth, maxDepth(child));
            }
        }

        return depth + 1; //中节点
    }

    //迭代法
    public int maxDepth2(Node root) {
        if(root == null){
            return 0;
        }
        int depth = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            depth++;
            int size = queue.size();
            while(size > 0){
                Node temp = queue.poll();
                for(int i = 0; i < temp.children.size();i++){
                    if(temp.children.get(i) != null){
                        queue.offer(temp.children.get(i));
                    }
                }
                size--;
            }
        }
        return depth;
    }
}
