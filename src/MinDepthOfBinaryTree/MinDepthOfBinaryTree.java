package MinDepthOfBinaryTree;

/**
 * Created by Siming on 6/10/15.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */
public class MinDepthOfBinaryTree
{
    public int minDepth (TreeNode root)
    {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        int depth = 0;
        boolean breakFlag = false;

        while (queue.isEmpty() == false)
        {
            Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
            depth++;

            for (TreeNode node : queue)
            {
                if (node.left == null && node.right == null)
                {
                    breakFlag = true;
                    break;
                }

                if (node.left != null)
                {
                    nextLevel.add(node.left);
                }

                if (node.right != null)
                {
                    nextLevel.add(node.right);
                }
            }

            if (breakFlag == false)
                queue = nextLevel;
            else
                break;
        }

        return depth;
    }
}
