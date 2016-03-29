package ConstructBinaryTree;

/**
 * Created by SimingYe on 2/22/16.
 */
public class ConstructBinaryTree3
{
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        int preStart = 0;
        int preEnd = preorder.length - 1;
        int inStart = 0;
        int inEnd = inorder.length - 1;

        return build(preorder, preStart, preEnd, inorder, inStart, inEnd);
    }

    public TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd)
    {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        int value = preorder[preStart];
        TreeNode node = new TreeNode(value);

        int pos = 0;
        for (int i = 0; i < inorder.length; i++)
        {
            if (inorder[i] == value)
            {
                pos = i;
                break;
            }
        }

        node.left = build(preorder, preStart+1, preStart+(pos-inStart), inorder, inStart, pos-1);
        node.right = build(preorder, preStart+(pos-inStart)+1, preEnd, inorder, pos+1, inEnd);

        return node;
    }
}
