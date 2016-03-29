package MaximumDepthOfBinaryTree;

/**
 * Created by SimingYe on 2/22/16.
 */
public class MaximumDepthOfBinaryTree2
{
    public int maxDepth(TreeNode root)
    {
        if (root == null)
            return 0;

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }
}
