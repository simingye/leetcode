package ValidateBinarySearchTree;

/**
 * Created by SimingYe on 2/12/16.
 */
public class ValidateBinarySearchTree2
{
    public boolean isValidBST(TreeNode root)
    {
        if (root == null)
            return true;

        return isValid(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public boolean isValid(TreeNode node, Double min, Double max)
    {
        if (node == null)
        {
            return true;
        }

        if (node.val <= min || node.val >= max)
        {
            return false;
        }

        return isValid(node.left, min, Double.valueOf(node.val)) && isValid(node.right, Double.valueOf(node.val), max);
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(3);
        TreeNode three = new TreeNode(2);
        TreeNode four = new TreeNode(4);

        one.right = two;
        two.left = three;
        two.right = four;

        ValidateBinarySearchTree2 test = new ValidateBinarySearchTree2();
        System.out.println(test.isValidBST(one));
    }
}
