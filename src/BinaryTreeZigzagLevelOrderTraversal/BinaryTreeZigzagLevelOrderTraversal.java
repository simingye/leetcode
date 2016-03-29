package BinaryTreeZigzagLevelOrderTraversal;

import java.util.*;

/**
 * Created by Siming on 10/3/15.
 */
public class BinaryTreeZigzagLevelOrderTraversal
{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();
        int lvl = 1;

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            Queue<TreeNode> level = new LinkedList<>(queue);
            queue.clear();
            List<Integer> list = new ArrayList<>();

            while (!level.isEmpty())
            {
                TreeNode node = level.poll();
                list.add(node.val);

                if (node.left != null)
                {
                    queue.add(node.left);
                }

                if (node.right != null)
                {
                    queue.add(node.right);
                }
            }

            if (lvl % 2 == 1)
            {
                result.add(list);
            }
            else
            {
                Collections.reverse(list);
                result.add(list);
            }

            lvl++;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(3);
        TreeNode two = new TreeNode(9);
        TreeNode three = new TreeNode(20);
        TreeNode four = new TreeNode(15);
        TreeNode five = new TreeNode(7);
        one.left = two;
        one.right = three;
        three.left = four;
        three.right = five;

        BinaryTreeZigzagLevelOrderTraversal test = new BinaryTreeZigzagLevelOrderTraversal();
        test.zigzagLevelOrder(one);
    }
}
