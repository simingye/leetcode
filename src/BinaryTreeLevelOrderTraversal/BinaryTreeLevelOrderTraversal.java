package BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Siming on 5/21/15.
 */
public class BinaryTreeLevelOrderTraversal
{
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> nodeValues = new ArrayList<>();

        Queue<TreeNode> current = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();

        if (root == null)
        {
            return result;
        }

        current.add(root);

        while (current.isEmpty() != true)
        {
            TreeNode node = current.poll();

            if (node.left != null)
            {
                next.add(node.left);
            }

            if (node.right != null)
            {
                next.add(node.right);
            }

            nodeValues.add(node.val);

            if (current.isEmpty() == true)
            {
                current = next;
                next = new LinkedList<>();
                result.add(nodeValues);
                nodeValues = new ArrayList<>();
            }
        }
        return result;
    }
}
