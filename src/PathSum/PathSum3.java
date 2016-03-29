package PathSum;

/**
 * Created by SimingYe on 3/22/16.
 */
public class PathSum3
{
    public boolean hasPathSum(TreeNode root, int sum)
    {
        if (root == null)
            return false;

        return hasPathSum(root, sum, 0);
    }

    public boolean hasPathSum(TreeNode root, int sum, int now)
    {
        if (root == null)
            return false;

        if (root.left == null && root.right == null)
        {
            return sum == now + root.val;
        }

        boolean left = hasPathSum(root.left, sum, root.val + now);
        boolean right = hasPathSum(root.right, sum, root.val + now);

        return left || right;
    }
}
