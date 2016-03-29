package BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Siming on 10/27/15.
 */
public class BinaryTreePostorderTraversal
{
    public List<Integer> postorderTraversal(TreeNode root)
    {
        List<Integer> results = new ArrayList<>();

        if (root == null)
            return results;

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty())
        {
            TreeNode node = stack1.pop();
            stack2.push(node);

            if (node.right != null)
                stack1.push(node.right);

            if (node.left != null)
                stack1.push(node.left);
        }

        while (!stack2.isEmpty())
        {
            results.add(stack2.pop().val);
        }

        return results;
    }
}
