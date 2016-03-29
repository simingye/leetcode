package InvertBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Siming on 7/1/15.
 */
public class InvertBinaryTree
{
    public TreeNode invertTree (TreeNode root)
    {
        if (root == null)
            return null;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (queue.isEmpty() == false)
        {
            TreeNode node = queue.poll();
            TreeNode temp;

            if (node.left != null || node.right != null)
            {
                temp = node.left;
                node.left = node.right;
                node.right = temp;
            }

            if (node.left != null)
            {
                queue.add(node.left);
            }

            if (node.right != null)
            {
                queue.add(node.right);
            }
        }

        return root;
    }
}
