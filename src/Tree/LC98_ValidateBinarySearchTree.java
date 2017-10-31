package Tree;

public class LC98_ValidateBinarySearchTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /*
    方法二是参考别人的，代码比较优雅，且效率更高
     */
    public boolean valid(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return valid(root.left, min, root.val) && valid(root.right, root.val, max);
    }
    public boolean isValidBST2(TreeNode root) {
        return valid(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        boolean rl = false;
        boolean rr = false;
        TreeNode nl = root.left;
        TreeNode nr = root.right;
        if (nl != null) {
            while (nl.right != null) {
                nl = nl.right;
            }
            if (nl.val < root.val)
                rl = true;
        } else
            rl = true;
        if (nr != null) {
            while (nr.left != null) {
                nr = nr.left;
            }
            if (nr.val > root.val)
                rr = true;
        } else
            rr = true;
        return rl && rr && isValidBST(root.left) && isValidBST(root.right);
    }
}
