package SameTree;

/**
 * Created by SimingYe on 3/1/16.
 */
public class SameTree3
{
    public boolean isSameTree(TreeNode p, TreeNode q)
    {
        if (p == null && q == null)
        {
            return true;
        }
        else if ((p != null && q == null) || (p == null && q != null))
        {
            return false;
        }
        else
        {
            if (p.val != q.val)
            {
                return false;
            }
            else
            {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }
    }
}
