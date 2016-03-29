package KthSmallestElementInBST;

import java.util.Stack;

/**
 * Created by Siming on 11/9/15.
 */
public class KthSmallestElementInBST
{
    public int kthSmallest(TreeNode root, int k)
    {
        if (root == null)
            return 0;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        int count = 0;

        while (p != null || !stack.isEmpty())
        {
            if (p != null)
            {
                stack.push(p);
                p = p.left;
            }
            else
            {
                p = stack.pop();
                count++;
                if (count == k)
                {
                    return p.val;
                }
                p = p.right;
            }
        }

        return 0;
    }
}
