package SymmetricTree;

/**
 * Created by SimingYe on 2/29/16.
 */
public class SymmetricTree3
{
    public boolean isSymmetric(TreeNode root)
    {
        if (root == null)
            return true;

        return isValid(root.left, root.right);
    }

    public boolean isValid(TreeNode left, TreeNode right)
    {
        if ((left == null && right != null) || (left != null && right == null))
        {
            return false;
        }
        else if (left != null && right != null)
        {
            if (left.val != right.val)
            {
                return false;
            }
            else
            {
                return isValid(left.left, left.right) && isValid(right.left, right.right);
            }
        }

        return true;
    }
}
