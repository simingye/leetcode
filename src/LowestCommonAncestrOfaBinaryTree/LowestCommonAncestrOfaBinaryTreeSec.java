package LowestCommonAncestrOfaBinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siming on 11/9/15.
 */
public class LowestCommonAncestrOfaBinaryTreeSec
{
    List<TreeNode> array = new ArrayList<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root == null || p == null || q == null)
            return null;

        if (root == p || root == q)
        {
            array.add(root);
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null && right == null)
        {
            return null;
        }
        else if (left == null && right != null)
        {
            array.add(right);
            return right;
        }
        else if (left != null && right == null)
        {
            array.add(left);
            return left;
        }
        else
        {
            array.add(root);
            return root;
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestrOfaBinaryTreeSec test = new LowestCommonAncestrOfaBinaryTreeSec();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;

        System.out.println(test.lowestCommonAncestor(one, four, three).val);
    }
}
