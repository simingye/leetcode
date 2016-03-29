package MinDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by SimingYe on 3/22/16.
 */
public class MinDepthOfBinaryTree3
{
    public int minDepth(TreeNode root)
    {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;

        while (!queue.isEmpty())
        {
            Queue<TreeNode> tempQueue = new LinkedList<>();

            while (!queue.isEmpty())
            {
                TreeNode node = queue.poll();

                if (node.left == null && node.right == null)
                {
                    return result + 1;
                }

                if (node.left != null)
                    tempQueue.add(node.left);

                if (node.right != null)
                    tempQueue.add(node.right);
            }

            queue = tempQueue;
            result++;
        }

        return result;
    }
}
