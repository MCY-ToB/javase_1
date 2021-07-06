package test06;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class Test02 {
    public static void main(String[] args) {

    }
    public boolean isCBT(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(queue.peek() != null){
            TreeNode cur = queue.poll();
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        while(!queue.isEmpty() && queue.peek() == null){
            queue.poll();
        }
        return queue.isEmpty();
    }
}

 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}
