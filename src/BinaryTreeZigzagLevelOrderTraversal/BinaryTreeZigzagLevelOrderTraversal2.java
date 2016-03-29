package BinaryTreeZigzagLevelOrderTraversal;

import BinaryTreeLevelOrderTraversal.BinaryTreeLevelOrderTraversal2;

import java.util.*;

/**
 * Created by SimingYe on 2/12/16.
 */
public class BinaryTreeZigzagLevelOrderTraversal2
{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean clockwise = true;

        while (!queue.isEmpty())
        {
            LinkedList<Integer> list = new LinkedList<>();
            Queue<TreeNode> tempQueue = new LinkedList<>();

            while (!queue.isEmpty())
            {
                TreeNode node = queue.poll();

                if (clockwise)
                {
                    list.addLast(node.val);
                }
                else
                {
                    list.addFirst(node.val);
                }

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
            clockwise = !clockwise;
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTreeZigzagLevelOrderTraversal2 test = new BinaryTreeZigzagLevelOrderTraversal2();

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        one.left = two;
        one.right = three;
        two.left = four;
        three.right = five;

        test.zigzagLevelOrder(one);
    }
}
