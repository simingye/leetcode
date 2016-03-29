package MaximumDepthOfBinaryTree;

/**
 * Created by SimingYe on 2/13/16.
 */
public class MaximumDepthOfBinaryTree
{
    public int maxDepth(TreeNode root)
    {
        if (root == null)
            return 0;

        int lmax = maxDepth(root.left);
        int rmax = maxDepth(root.right);

        return Math.max(lmax, rmax) + 1;
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree test = new MaximumDepthOfBinaryTree();

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);

        one.left = two;
        two.left = three;
        one.right = four;

        System.out.println(test.maxDepth(one));
    }
}
