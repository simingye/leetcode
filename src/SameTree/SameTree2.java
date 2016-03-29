package SameTree;

/**
 * Created by SimingYe on 2/12/16.
 */
public class SameTree2
{
    public boolean isSameTree(TreeNode p, TreeNode q)
    {
        if (p == null && q == null)
        {
            return true;
        }
        else if ((p == null && q != null) || (p != null && q == null))
        {
            return false;
        }
        else
        {
            if (q.val == p.val)
            {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);

        one.left = two;
        one.right = three;
        two.right = four;

        TreeNode one2 = new TreeNode(1);
        TreeNode two2 = new TreeNode(2);
        TreeNode three2 = new TreeNode(3);
        TreeNode four2 = new TreeNode(4);

        one2.left = two2;
        one2.right = three2;
        two2.right = four2;

        SameTree2 test = new SameTree2();
        System.out.println(test.isSameTree(one, one2));
    }
}
