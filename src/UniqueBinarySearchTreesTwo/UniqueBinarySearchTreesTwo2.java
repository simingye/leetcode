package UniqueBinarySearchTreesTwo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by SimingYe on 2/12/16.
 */
public class UniqueBinarySearchTreesTwo2
{
    public List<TreeNode> generateTree(int n)
    {
        List<TreeNode> list = new LinkedList<>();

        if (n <= 0)
            return list;

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
            List<TreeNode> lefts = generate(start, i-1);
            List<TreeNode> rights = generate(i+1, end);

            for (TreeNode left : lefts)
            {
                for (TreeNode right : rights)
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
