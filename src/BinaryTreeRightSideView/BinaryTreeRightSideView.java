package BinaryTreeRightSideView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Siming on 6/17/15.
 */
public class BinaryTreeRightSideView
{
    public List<Integer> rightSideView (TreeNode root)
    {
        List<Integer> result = new ArrayList<Integer>();

        if (root == null)
            return result;

//        result.add(root.val);

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (queue.isEmpty() == false)
        {
            Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();
            boolean isFirst = true;

            while (queue.isEmpty() == false)
            {
                TreeNode node = queue.poll();

                if (isFirst == true)
                {
                    result.add(node.val);
                    isFirst = false;
                }

                if (node.right != null)
                    nextLevel.add(node.right);

                if (node.left != null)
                    nextLevel.add(node.left);
            }

            isFirst = true;
            queue = nextLevel;
        }

        return result;
    }

    public static void main(String[] args) {
        BinaryTreeRightSideView test = new BinaryTreeRightSideView();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node2.left = node1;

        System.out.println(test.rightSideView(node1));
    }
}
