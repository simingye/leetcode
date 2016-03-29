package PathSumTwo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SimingYe on 3/22/16.
 */
public class PathSumTwo3
{
    public List<List<Integer>> pathSum(TreeNode root, int sum)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        List<Integer> now = new ArrayList<>();
        now.add(root.val);

        dfs(result, now, root, sum);

        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> now, TreeNode node, int sum)
    {
        if (node.left == null && node.right == null)
        {
            int temp = 0;
            for (int element : now)
            {
                temp += element;
            }

            if (temp == sum)
            {
                List<Integer> list = new ArrayList<>(now);
                result.add(list);
                return;
            }
            else
            {
                return;
            }
        }

        if (node.left != null)
        {
            now.add(node.left.val);
            dfs(result, now, node.left, sum);
            now.remove(now.size() -1);
        }

        if (node.right != null)
        {
            now.add(node.right.val);
            dfs(result, now, node.right, sum);
            now.remove(now.size() - 1);
        }
    }
}
