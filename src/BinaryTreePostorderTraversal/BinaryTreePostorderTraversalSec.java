package BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Siming on 10/27/15.
 */
public class BinaryTreePostorderTraversalSec
{
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> results = new ArrayList<>();

        if (root == null)
            return results;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        while (!stack.isEmpty() || p != null)
        {
            if (p != null)
            {
                stack.push(p);
                p = p.left;
            }
            else
            {
                p = stack.pop();
                results.add(p.val);
                p = p.right;
            }
        }

        return results;
    }
}
