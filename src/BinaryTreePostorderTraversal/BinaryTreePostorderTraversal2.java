package BinaryTreePostorderTraversal;

import AddBinary.AddBinary;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by SimingYe on 3/28/16.
 */
public class BinaryTreePostorderTraversal2
{
    public List<Integer> postorderTraversal(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        Stack<TreeNode> stack2 = new Stack<>();

        while (!stack.isEmpty())
        {
            TreeNode node = stack.pop();

            stack2.push(node);

            if (node.left != null)
                stack.push(node.left);

            if (node.right != null)
                stack.push(node.right);
        }

        while (!stack2.isEmpty())
        {
            result.add(stack2.pop().val);
        }

        return result;
    }
}
