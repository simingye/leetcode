package PathSum;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Siming on 6/13/15.
 */
public class PathSum
{
    public boolean hasPathSum (TreeNode root, int sum)
    {
        if (root == null)
            return false;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);

        while (stack.isEmpty() == false)
        {
            TreeNode node = stack.pop();

            if (node.left != null)
            {
                stack.push(node.left);
                node.left.val = node.left.val + node.val;
            }

            if (node.right != null)
            {
                stack.push(node.right);
                node.right.val = node.right.val + node.val;
            }

            if (node.left == null && node.right == null)
            {
                if (node.val == sum)
                {
                    return true;
                }
            }
        }

        return false;
    }
}
