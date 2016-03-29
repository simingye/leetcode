package MinDepthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by SimingYe on 2/24/16.
 */
public class MinDepthOfBinaryTree2
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
            Queue<TreeNode> temp = new LinkedList<>();

            while (!queue.isEmpty())
            {
                TreeNode node = queue.poll();

                if (node.left != null)
                {
                    temp.add(node.left);
                }

                if (node.right != null)
                {
                    temp.add(node.right);
                }

                if (node.left == null && node.right == null)
                {
                    return result;
                }
            }

            queue = temp;
            result++;
        }

        return result;
    }
}
