package BinaryTreePath;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Siming on 9/1/15.
 */
public class BinaryTreePath
{
    public List<String> binaryTreePaths(TreeNode root)
    {
        List<String> result = new ArrayList<>();

        if (root != null)
            getPaths(result, root, "");

        return result;
    }

    public void getPaths(List<String> result, TreeNode root, String str)
    {
        if (str.equalsIgnoreCase(""))
        {
            str += root.val;
        }
        else
        {
            str +=  "->" + root.val;
        }

        if (root.left == null && root.right == null)
        {
            result.add(str);
            return;
        }

        if (root.left != null)
        {
            getPaths(result, root.left, str);
        }

        if (root.right != null)
        {
            getPaths(result, root.right, str);
        }
    }

    public static void main(String[] args) {
        BinaryTreePath test = new BinaryTreePath();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);

        root.left = node1;
        root.right = node2;
        node1.right = node3;

        System.out.println(test.binaryTreePaths(root));
    }
}
