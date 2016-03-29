package BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Siming on 10/2/15.
 */
public class BinaryTreeInorderTraveral
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
                p = stack.pop();
                result.add(p.val);
                p = p.right;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        one.right = two;
        two.left = three;

        BinaryTreeInorderTraveral test = new BinaryTreeInorderTraveral();
        System.out.println(test.inorderTraversal(one));
    }
}
