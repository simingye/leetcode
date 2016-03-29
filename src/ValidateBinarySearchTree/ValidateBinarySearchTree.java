package ValidateBinarySearchTree;

import java.util.Stack;

/**
 * Created by Siming on 10/2/15.
 */
public class ValidateBinarySearchTree
{
    public boolean isValidBST(TreeNode root)
    {
        return isValid(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public boolean isValid(TreeNode node, Double min, Double max)
    {
        if (node == null)
            return true;

        if (node.val >= max || node.val <= min)
            return false;

        return isValid(node.left, min, (double)node.val) && isValid(node.right, (double)node.val, max);
    }
}
