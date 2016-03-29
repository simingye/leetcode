package MaxDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Siming on 6/4/15.
 */
public class MaxDepthOfBinaryTree
{
//    public int maxDepth (TreeNode root)
//    {
//        if (root == null)
//            return 0;
//
//        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
//    }

    public int maxDepth (TreeNode root)
    {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        int depth = 0;

        while (queue.isEmpty() == false)
        {
            Queue<TreeNode> next = new LinkedList<TreeNode>();

            for (TreeNode node : queue)
            {
                if (node.left != null)
                {
                    next.add(node.left);
                }

                if (node.right != null)
                {
                    next.add(node.right);
                }
            }

            queue = next;
            depth++;
        }

        return depth;
    }
}
