package FlattenBinaryTreeToLinkedList;

/**
 * Created by Siming on 10/18/15.
 */
public class FlattenBinaryTreeToLinkedList
{
    public void flatten(TreeNode root)
    {
        if (root == null)
            return;

        TreeNode node = root;

        while (node != null)
        {
            TreeNode left = node.left;
            TreeNode right = node.right;

            if (left != null)
            {
                while (left.right != null)
                {
                    left = left.right;
                }

                left.right = right;
                node.right = node.left;
                node.left = null;
            }

            node = node.right;
        }
    }

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList test = new FlattenBinaryTreeToLinkedList();
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        one.left = two;
        one.right = five;
        two.left = three;
        two.right = four;
        five.right = six;

        test.flatten(one);
    }
}
