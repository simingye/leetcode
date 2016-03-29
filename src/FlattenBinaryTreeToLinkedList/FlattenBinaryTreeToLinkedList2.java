package FlattenBinaryTreeToLinkedList;

/**
 * Created by SimingYe on 2/24/16.
 */
public class FlattenBinaryTreeToLinkedList2
{
    public void flatten(TreeNode root)
    {
        if (root == null)
            return;

        TreeNode node = root;

        while (node != null)
        {
            if (node.left == null)
            {
                node = node.right;
            }
            else
            {
                TreeNode temp = node.right;
                TreeNode n = node.left;
                node.right = node.left;
                node.left = null;

                while (n.right != null)
                {
                    n = n.right;
                }
                n.right = temp;

                node = node.right;
            }
        }

        System.out.println("");
    }

    public static void main(String[] args) {
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

        FlattenBinaryTreeToLinkedList2 test = new FlattenBinaryTreeToLinkedList2();
        test.flatten(one);
    }
}
