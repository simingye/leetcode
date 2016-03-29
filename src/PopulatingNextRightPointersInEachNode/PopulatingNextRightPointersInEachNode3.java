package PopulatingNextRightPointersInEachNode;

/**
 * Created by SimingYe on 3/22/16.
 */
public class PopulatingNextRightPointersInEachNode3
{
    public void connect(TreeLinkNode root)
    {
        if (root == null)
            return;

        if (root.left != null && root.right != null)
        {
            root.left.next = root.right;

            if (root.next != null)
            {
                root.right.next = root.next.left;
            }
        }

        connect(root.left);
        connect(root.right);
    }
}
