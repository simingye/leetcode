package SymmetricTree;

/**
 * Created by Siming on 6/4/15.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 */
public class SymmetricTree
{
//    public boolean isSymmetric (TreeNode root)
//    {
//        if (root == null)
//        {
//            return true;
//        }
//
//        return isSymmetric(root.left, root.right);
//    }
//
//    public boolean isSymmetric (TreeNode left, TreeNode right)
//    {
//        if (left == null && right == null)
//            return  true;
//        else if (left == null || right == null)
//            return false;
//
//        if (left.val != right.val)
//            return false;
//
//        if (isSymmetric(left.left, right.right) != true)
//            return false;
//
//        if (isSymmetric(left.right, right.left) != true)
//            return  false;
//
//        return true;
//    }

    public boolean isSymmetric (TreeNode root)
    {
        if (root == null)
            return true;

        LinkedList<TreeNode> left = new LinkedList<TreeNode>();
        LinkedList<TreeNode> right = new LinkedList<TreeNode>();

        left.add(root.left);
        right.add(root.right);

        while (!left.isEmpty() && !right.isEmpty())
        {
            TreeNode temp1 = left.poll();
            TreeNode temp2 = right.poll();

            if (temp1 == null && temp2 != null)
                return false;
            else if (temp1 != null && temp2 == null)
                return false;


            if (temp1 != null && temp2 != null)
            {
                if (temp1.val == temp2.val)
                {
                    left.add(temp1.left);
                    left.add(temp1.right);
                    right.add(temp2.right);
                    right.add(temp2.left);
                }
                else
                {
                    return  false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        SymmetricTree test = new SymmetricTree();
        TreeNode node = new TreeNode(1);
        System.out.println(test.isSymmetric(node));
    }
}
