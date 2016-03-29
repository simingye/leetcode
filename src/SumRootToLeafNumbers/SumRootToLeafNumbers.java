package SumRootToLeafNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siming on 10/22/15.
 */
public class SumRootToLeafNumbers
{
    public int sumNumbers(TreeNode root)
    {
        if (root == null)
            return 0;

        int result = 0;
        List<Integer> paths = new ArrayList<>();
        int item  = 0;

        dfs(paths, item, root);

        for (int element : paths)
        {
            result += element;
        }

        return result;
    }

    public void dfs(List<Integer> paths, int item, TreeNode root)
    {
        if (root.left == null && root.right == null)
        {
            paths.add(10 * item + root.val);
            return;
        }

        if (root.left != null)
        {
            dfs(paths, 10 * item + root.val, root.left);
        }

        if (root.right != null)
        {
            dfs(paths, 10 * item + root.val, root.right);
        }
    }

    public static void main(String[] args) {
        SumRootToLeafNumbers test = new SumRootToLeafNumbers();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
//        TreeNode three = new TreeNode(3);
//        TreeNode four = new TreeNode(4);

        one.left = two;
//        one.right = three;
//        three.right = four;

        System.out.println(test.sumNumbers(one));
    }
}
