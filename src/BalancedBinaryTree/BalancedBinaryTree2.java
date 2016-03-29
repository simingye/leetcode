package BalancedBinaryTree;

/**
 * Created by SimingYe on 2/23/16.
 */
public class BalancedBinaryTree2
{
    public boolean isBalanced(TreeNode root)
    {
        if (root == null)
            return true;

        if (Math.abs(depth(root.left) - depth(root.right)) <= 1)
        {
            return isBalanced(root.left) && isBalanced(root.right);
        }

        return false;
    }

    public int depth(TreeNode root)
    {
        if (root == null)
            return 0;

        int ldepth = depth(root.left);
        int rdepth = depth(root.right);

        return Math.max(ldepth, rdepth) + 1;
    }
}
