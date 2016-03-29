package LowestCommonAncestorOfaBinarySearchTree;

/**
 * Created by Siming on 11/9/15.
 */
public class LowestCommonAncestorOfaBinarySearchTree
{
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root == null || p == null || q == null)
            return null;

        if (root.val < p.val && root.val < q.val)
        {
            return lowestCommonAncestor(root.right, p, q);
        }
        else if (root.val > p.val && root.val > q.val)
        {
            return lowestCommonAncestor(root.left, p, q);
        }
        else
        {
            return root;
        }
    }
}
