package PathSumTwo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by SimingYe on 2/24/16.
 */
public class PathSumTwo2
{
    public List<List<Integer>> pathSum(TreeNode root, int sum)
    {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        List<Integer> element = new LinkedList<>();
        element.add(root.val);

        dfs(result, element, sum, root.val, root);

        return result;
    }

    public void dfs(List<List<Integer>> result, List<Integer> element, int sum, int current, TreeNode node)
    {
        if (node.left == null && node.right == null)
        {
            if (sum == current)
            {
                List<Integer> temp = new ArrayList<>(element);
                result.add(temp);
                return;
            }
            else
            {
                return;
            }
        }

        if (node.left != null)
        {
            element.add(node.left.val);
            dfs(result, element, sum, current+node.left.val, node.left);
            element.remove(element.size() - 1);
        }

        if (node.right != null)
        {
            element.add(node.right.val);
            dfs(result, element, sum, current+node.right.val, node.right);
            element.remove(element.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        PathSumTwo2 test = new PathSumTwo2();
        test.pathSum(one, 1);
    }
}
