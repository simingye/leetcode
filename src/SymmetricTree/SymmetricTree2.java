package SymmetricTree;

/**
 * Created by SimingYe on 2/12/16.
 */
public class SymmetricTree2
{
    public boolean isSymmetric(TreeNode root)
    {
        if (root == null)
            return true;

        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right)
    {
        if (left == null && right == null)
        {
            return true;
        }
        else if ((left == null && right != null) || (left != null && right == null))
        {
            return false;
        }
        else
        {
            if (left.val == right.val)
            {
                return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
            }
            else
            {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(2);
        TreeNode four = new TreeNode(3);
        TreeNode five = new TreeNode(4);
        TreeNode six = new TreeNode(4);
        TreeNode seven = new TreeNode(3);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;

        SymmetricTree2 test = new SymmetricTree2();
        System.out.println(test.isSymmetric(one));
    }

}
