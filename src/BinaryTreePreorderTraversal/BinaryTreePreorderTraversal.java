package BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Siming on 10/27/15.
 */
public class BinaryTreePreorderTraversal
{
    public List<Integer> preorderTraversal(TreeNode root)
    {
        List<Integer> results = new ArrayList<>();

        if (root == null)
            return results;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty())
        {
            TreeNode node = stack.pop();
            results.add(node.val);

            if (node.right != null)
            {
                stack.push(node.right);
            }

            if (node.left != null)
            {
                stack.push(node.left);
            }
        }

        return results;
    }
}
