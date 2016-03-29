package Interview;

import java.util.*;

/**
 * Created by Siming on 11/11/15.
 */
public class bfs
{
    public int getShortLength(TreeNode root, TreeNode targetNode)
    {
        if (root == null)
            return 0;

        Queue<TreeNode> queue = new LinkedList<>();

        //key -> child; value -> parent
        Map<TreeNode, TreeNode> map = new HashMap<>();
        queue.add(root);
        map.put(root, null);
        int result = 1;

        while (!queue.isEmpty())
        {
            Queue<TreeNode> tempQueue = new LinkedList<>();

            while (!queue.isEmpty())
            {
                TreeNode node = queue.poll();

                if (node == targetNode)
                {
                    TreeNode n = node;

                    while (n != null)
                    {
                        if (n == root)
                        {
                            System.out.println(n.val);
                        }
                        else
                        {
                            System.out.print(n.val + " -> ");
                        }

                        n = map.get(n);
                    }
                    return result;
                }


                if (node.left != null)
                {
                    tempQueue.add(node.left);
                    map.put(node.left, node);
                }

                if (node.right != null)
                {
                    tempQueue.add(node.right);
                    map.put(node.right, node);
                }

            }

            result++;
            queue = tempQueue;
        }

        return 0;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        five.right = eight;

        bfs test = new bfs();
        System.out.println(test.getShortLength(one, eight));
    }
}
