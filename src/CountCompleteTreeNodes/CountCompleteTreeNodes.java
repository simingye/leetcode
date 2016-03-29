package CountCompleteTreeNodes;

/**
 * Created by Siming on 11/8/15.
 */
public class CountCompleteTreeNodes
{
    public int countNodes(TreeNode root)
    {
        if (root == null)
            return 0;

        int left = getLeftHeight(root);
        int right = getRightHeight(root);

        if (left == right)
        {
            return (2 << (left - 1)) - 1;
        }
        else
        {
            return countNodes(root.left) + countNodes(root.right) + 1;
        }
    }

    public int getLeftHeight(TreeNode left)
    {
        if (left == null)
            return 0;

        int count = 1;
        while (left.left != null)
        {
            left = left.left;
            count++;
        }

        return count;
    }

    public int getRightHeight(TreeNode right)
    {
        if (right == null)
            return 0;

        int count = 1;
        while (right.right != null)
        {
            right = right.right;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        CountCompleteTreeNodes test = new CountCompleteTreeNodes();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        one.left = two;
        two.left = four;
        two.right = five;
        one.right = three;

        System.out.println(test.countNodes(one));
    }
}
