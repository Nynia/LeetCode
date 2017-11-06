package Tree;

public class LC337_HouseRobberIII {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int[] helper(TreeNode node) {
        int[] res = new int[2];
        if (node != null) {
            int[] left = helper(node.left);
            int[] right = helper(node.right);
            int r11 = left[1] + right[1];
            int r10 = left[1] + right[0];
            int r01 = left[0] + right[1];
            int r00 = left[0] + right[0];

            res[0] = Math.max(Math.max(r11, r10), Math.max(r01, r00));
            res[1] = node.val + r00;
        }
        return res;

    }

    public int rob(TreeNode root) {
        return Math.max(helper(root)[0], helper(root)[1]);
    }
}
