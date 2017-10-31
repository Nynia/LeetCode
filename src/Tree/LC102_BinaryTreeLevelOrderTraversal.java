package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC102_BinaryTreeLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    /*
    本题也可以使用DFS算法
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmplist = new ArrayList<>();
        if (root == null)
            return res;
        while (!queue.isEmpty()) {
            int c = queue.size();
            while (c != 0) {
                TreeNode tmpnode = queue.poll();
                tmplist.add(tmpnode.val);

                if (tmpnode.left != null) queue.offer(tmpnode.left);
                if (tmpnode.right != null) queue.offer(tmpnode.right);

                c--;

            }
            res.add(new ArrayList<Integer>(tmplist));
            tmplist.clear();
        }
        return res;
    }
}
