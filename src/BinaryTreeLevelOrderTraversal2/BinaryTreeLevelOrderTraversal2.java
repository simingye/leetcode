package BinaryTreeLevelOrderTraversal2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Siming on 6/13/15.
 */
public class BinaryTreeLevelOrderTraversal2
{
    public List<List<Integer>> levelOrderBottom (TreeNode root)
    {
        List<List<Integer>> result = new LinkedList<>();
        List<List<Integer>> temp = new LinkedList<>();
        List<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        if (root == null)
            return temp;

        while (queue.isEmpty() == false)
        {
            List<TreeNode> nextLevel = new LinkedList<TreeNode>();
            List<Integer> nextLevelVal = new LinkedList<Integer>();

            for (TreeNode node : queue)
            {
                if (node.left != null)
                {
                    nextLevel.add(node.left);
                }

                if (node.right != null)
                {
                    nextLevel.add(node.right);
                }

                nextLevelVal.add(node.val);
            }

            result.add(nextLevelVal);
            queue = nextLevel;
        }

        for (int i = result.size() - 1; i >= 0; i--)
        {
            temp.add(result.get(i));
        }

        return temp;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
//        TreeNode two = new TreeNode(2);
//        TreeNode three = new TreeNode(3);
//        one.left = two;
//        one.right = three;
        BinaryTreeLevelOrderTraversal2 test = new BinaryTreeLevelOrderTraversal2();
        List<List<Integer>> result = new LinkedList<>();
        result = test.levelOrderBottom(one);
    }
}
