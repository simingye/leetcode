package BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by SimingYe on 3/10/16.
 */
public class BinaryTreeInorderTraveral3
{
    public List<Integer> inorderTraversal(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        Stack<TreeNode> stack = new Stack<>();
        TreeNode now = root;

        while (now != null || !stack.isEmpty())
        {
            if (now != null)
            {
                stack.push(now);
                now = now.left;
            }
            else
            {
                TreeNode temp = stack.pop();
                result.add(temp.val);
                now = temp.right;
            }
        }

        return result;
    }
}
