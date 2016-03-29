package BinaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by SimingYe on 2/12/16.
 */
public class BinaryTreeLevelOrderTraversal2
{
    public List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            List<Integer> list = new ArrayList<>();
            Queue<TreeNode> tempQueue = new LinkedList<>();

            while (!queue.isEmpty())
            {
                TreeNode node = queue.poll();
                list.add(node.val);

                if (node.left != null)
                {
                    tempQueue.add(node.left);
                }

                if (node.right != null)
                {
                    tempQueue.add(node.right);
                }
            }

            result.add(list);
            queue = tempQueue;
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal2 test = new BinaryTreeLevelOrderTraversal2();

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        one.left = two;
        one.right = three;
        two.right = four;
        three.left = five;

        test.levelOrder(one);
    }
}
