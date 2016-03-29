package UniqueBinarySearchTreesTwo;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Siming on 10/2/15.
 */
public class UniqueBinarySearchTreesTwo
{
    public List<TreeNode> generateTrees(int n)
    {
        return generate(1, n);
    }

    public List<TreeNode> generate(int start, int end)
    {
        List<TreeNode> list = new LinkedList<>();

        if (start > end)
        {
            list.add(null);
            return list;
        }

        for (int i = start; i <= end; i++)
        {
            List<TreeNode> lefts = generate(start, i - 1);
            List<TreeNode> rights = generate(i+1, end);

            for (TreeNode left: lefts)
            {
                for (TreeNode right: rights)
                {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    list.add(node);
                }
            }
        }

        return list;
    }
}
