package SumRootToLeafNumbers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by SimingYe on 3/24/16.
 */
public class SumRootToLeafNumbers3
{
    public int sumNumbers(TreeNode root)
    {
        if (root == null)
            return 0;

        int result = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        Queue<Integer> list = new LinkedList<>();
        list.add(root.val);

        List<Integer> results = new ArrayList<>();

        while (!queue.isEmpty())
        {
            Queue<TreeNode> tempQueue = new LinkedList<>();
            Queue<Integer> tempList = new LinkedList<>();

            while (!queue.isEmpty())
            {
                TreeNode node = queue.poll();
                int i = list.poll();

                if (node.left != null)
                {
                    tempQueue.add(node.left);
                    tempList.add(i * 10 + node.left.val);
                }

                if (node.right != null)
                {
                    tempQueue.add(node.right);
                    tempList.add(i * 10 + node.right.val);
                }

                if (node.left == null && node.right == null)
                {
                    results.add(i);
                }
            }

            queue = tempQueue;
            list = tempList;
        }

        for (int element : results)
        {
            result += element;
        }

        return result;
    }
}
