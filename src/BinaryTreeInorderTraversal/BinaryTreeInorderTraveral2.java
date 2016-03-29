package BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by SimingYe on 2/12/16.
 */
public class BinaryTreeInorderTraveral2
{
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

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
                TreeNode t = stack.pop();
                result.add(t.val);
                p = t.right;
            }
        }

        return result;
    }
}
