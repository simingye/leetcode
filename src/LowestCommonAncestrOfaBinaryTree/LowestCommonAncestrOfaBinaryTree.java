package LowestCommonAncestrOfaBinaryTree;

import RotateArray.RotateArray;

/**
 * Created by Siming on 11/9/15.
 */
public class LowestCommonAncestrOfaBinaryTree
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root == null || p == null || q == null)
            return null;

        if (root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right= lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null)
            return root;
        else if (left != null && right == null)
            return left;
        else if (left == null && right != null)
            return right;
        else
            return null;
    }
}
