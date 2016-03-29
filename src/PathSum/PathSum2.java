package PathSum;

import java.util.List;
import java.util.Stack;

/**
 * Created by SimingYe on 2/24/16.
 */
public class PathSum2
{
    public boolean hasPanSum(TreeNode root, int sum)
    {
        if (root == null)
            return false;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty())
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
                node.right.val += node.val;
            }

            if (node.left == null && node.right == null && node.val == sum)
            {
                return true;
            }
        }

        return false;
    }

}
