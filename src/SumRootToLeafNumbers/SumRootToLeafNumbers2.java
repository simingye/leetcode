package SumRootToLeafNumbers;

import RotateArray.RotateArray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SimingYe on 3/1/16.
 */
public class SumRootToLeafNumbers2
{
    int sum = 0;

    public int sumNumber(TreeNode root)
    {
        if (root == null)
            return 0;

        List<TreeNode> list = new ArrayList<>();
        list.add(root);
        dfs(list, root);

        return sum;
    }

    public void dfs(List<TreeNode> list, TreeNode node)
    {
        if (node == null)
            return;

        if (node.left == null && node.right == null)
        {
            int temp = 0;
            for (int i = 0; i < list.size(); i++)
            {
                temp = temp * 10 + list.get(i).val;
            }

            sum += temp;
        }

        if (node.left != null)
        {
            list.add(node.left);
            dfs(list, node.left);
            list.remove(list.size()-1);
        }

        if (node.right != null)
        {
            list.add(node.right);
            dfs(list, node.right);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        SumRootToLeafNumbers2 test = new SumRootToLeafNumbers2();
        TreeNode one = new TreeNode(9);
        System.out.println(test.sumNumber(one));
    }
}
