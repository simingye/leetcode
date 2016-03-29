package SameTree;

/**
 * Created by Siming on 6/4/15.
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class SameTree
{
    public boolean isSameTree (TreeNode p, TreeNode q)
    {
        if (p == null && q == null)
        {
            return true;
        }
        else if (p != null && q != null)
        {
            if (p.val == q.val)
            {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }
}
