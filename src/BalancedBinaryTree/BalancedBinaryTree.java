package BalancedBinaryTree;

/**
 * Created by Siming on 5/20/15.
 */

public class BalancedBinaryTree
{
    public boolean isBanlanced(TreeNode root)
    {
        if (root == null)
            return true;

        if (Math.abs(depthOfNode(root.left) - depthOfNode(root.right)) > 1)
            return false;

        return isBanlanced(root.left) && isBanlanced(root.right);
    }

    public int depthOfNode(TreeNode node)
    {
        if (node == null)
            return 0;
        return 1 + Math.max(depthOfNode(node.left), depthOfNode(node.right));
    }

    public static void main(String[] args)
    {
        BalancedBinaryTree bbt = new BalancedBinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;

        System.out.println(bbt.depthOfNode(root));
    }
}
