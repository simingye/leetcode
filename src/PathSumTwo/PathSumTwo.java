package PathSumTwo;

import RestoreIPAddresses.RestoreIPAddress;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siming on 10/15/15.
 */
public class PathSumTwo
{
    public List<List<Integer>> pathSum(TreeNode root, int sum)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> finalResult = new ArrayList<>();
        List<Integer> item = new ArrayList<>();

        if (root == null)
            return result;

        dfs(result, item, root);

        for (List<Integer> element : result)
        {
            int count = 0;
            for (int i : element)
            {
                count += i;
            }

            if (count == sum)
            {
                finalResult.add(element);
            }
        }

        return finalResult;
    }

    public void dfs(List<List<Integer>> path, List<Integer> item, TreeNode root)
    {
        if (root == null)
            return;

        item.add(root.val);

        if (root.left == null && root.right == null)
        {
            List<Integer> temp = new ArrayList<>(item);
            path.add(temp);
            return;
        }

        if (root.left != null)
        {
            dfs(path, item, root.left);
            item.remove(item.size()-1);
        }

        if (root.right != null)
        {
            dfs(path, item, root.right);
            item.remove(item.size()-1);
        }
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(5);
        TreeNode two = new TreeNode(4);
        TreeNode three = new TreeNode(8);
        TreeNode four = new TreeNode(11);
        TreeNode five = new TreeNode(13);
        TreeNode six = new TreeNode(4);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(2);
        TreeNode nine = new TreeNode(5);
        TreeNode ten = new TreeNode(1);

        one.left = two;
        one.right = three;
        two.left = four;
        three.left = five;
        three.right = six;
        four.left = seven;
        four.right = eight;
        six.left = nine;
        six.right = ten;

        PathSumTwo test = new PathSumTwo();
        test.pathSum(one, 22);
    }
}
