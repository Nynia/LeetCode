package Tree;

public class LC105_ConstructBinaryTreefromPreorderandInorderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    public TreeNode helper(int[] preorder, int pl, int[] inorder, int il, int ir) {
        if (pl == preorder.length || il > ir) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pl]);
        int index = 0;
        for (int i = il; i <= ir; i++) {
            if (inorder[i] == preorder[pl]) {
                index = i;
                break;
            }
        }

        root.left = helper(preorder, pl + 1, inorder, il, index - 1);
        root.right = helper(preorder, pl + index - il + 1, inorder, index + 1, ir);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, inorder, 0, inorder.length - 1);
    }
}
