package Tree;

public class LC437_PathSumIII {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int dfs(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = 0;
        if (sum == root.val) res++;

        res += dfs(root.left, sum - root.val);
        res += dfs(root.right, sum - root.val);

        return res;
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
}
