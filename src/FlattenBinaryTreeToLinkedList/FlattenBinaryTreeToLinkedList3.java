package FlattenBinaryTreeToLinkedList;

/**
 * Created by SimingYe on 3/22/16.
 */
public class FlattenBinaryTreeToLinkedList3
{
    public void flatten(TreeNode root)
    {
        if (root == null)
            return;

        TreeNode node = root;

        while (node != null)
        {
            if (node.left != null)
            {
                TreeNode right = node.right;
                TreeNode left = node.left;

                node.right = left;
                node.left = null;
                while (left.right != null)
                {
                    left = left.right;
                }

                left.right = right;
            }
            else
            {
                node = node.right;
            }
        }
    }
}
