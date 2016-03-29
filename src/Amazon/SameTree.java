package Amazon;

/**
 * Created by SimingYe on 2/17/16.
 */
public class SameTree
{
    public int check(TreeNode p, TreeNode q)
    {
        if (q == null)
        {
            return 1;
        }

        if (isSubTree(p, q))
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }

    public boolean isSubTree(TreeNode p, TreeNode q)
    {
        if (p == null)
        {
            return false;
        }
        else if (p.val == q.val && isSameTree(p, q))
        {
            return true;
        }
        else
        {
            return (isSubTree(p.left, q) || isSubTree(p.right, q));
        }
    }

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
}
