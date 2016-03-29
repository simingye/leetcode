package LowestCommonAncestrOfaBinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siming on 11/9/15.
 */
public class LowestCommonAncestrOfaBinaryTreeTrd
{
    List<TreeNode> leftPath = new ArrayList<>();
    List<TreeNode> rightPath = new ArrayList<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root == null || p == null || q == null)
            return null;

        List<TreeNode> item = new ArrayList<>();

        dfs(root, item, p, 1);
        item.clear();
        dfs(root, item, q, 2);

        int i = Math.min(leftPath.size(), rightPath.size()) - 1;
        while (i >= 0)
        {
            if (leftPath.get(i) == rightPath.get(i))
            {
                return leftPath.get(i);
            }

            i--;
        }

        return null;
    }

    public void dfs(TreeNode root, List<TreeNode> item, TreeNode desNode, int flag)
    {
        if (root == desNode)
        {
            List<TreeNode> temp = new ArrayList<>(item);
            temp.add(root);
            if (flag == 1)
            {
                leftPath = temp;
            }
            else
            {
                rightPath = temp;
            }

            return;
        }

        if (root.left != null)
        {
            item.add(root);
            dfs(root.left, item, desNode, flag);
            item.remove(item.size() - 1);
        }

        if (root.right != null)
        {
            item.add(root);
            dfs(root.right, item, desNode, flag);
            item.remove(item.size() - 1);
        }
    }

    public static void main(String[] args) {
        LowestCommonAncestrOfaBinaryTreeTrd test = new LowestCommonAncestrOfaBinaryTreeTrd();
        TreeNode one = new TreeNode(-1);
        TreeNode two = new TreeNode(0);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(-2);
        TreeNode five = new TreeNode(4);
        TreeNode six = new TreeNode(8);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        four.left = six;

        System.out.println(test.lowestCommonAncestor(one, six, five).val);
    }
}
