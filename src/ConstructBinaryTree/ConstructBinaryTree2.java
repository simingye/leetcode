package ConstructBinaryTree;

/**
 * Created by SimingYe on 2/13/16.
 */
public class ConstructBinaryTree2
{
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        int preStart = 0;
        int preEnd = preorder.length - 1;
        int inStart = 0;
        int inEnd = inorder.length - 1;

        return construct(preorder, inorder, preStart, preEnd, inStart, inEnd);
    }

    public TreeNode construct(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd)
    {
        if (preStart > preEnd || inStart > inEnd)
            return null;

        int value = preorder[preStart];
        TreeNode p = new TreeNode(value);

        int k = 0;
        for (int i = 0; i < inorder.length; i++)
        {
            if (value == inorder[i])
            {
                k = i;
                break;
            }
        }

        p.left = construct(preorder, inorder, preStart+1, preStart+(k-inStart), inStart, k-1);
        p.right = construct(preorder, inorder, preStart+(k-inStart)+1, preEnd, k+1, inEnd);

        return p;
    }
}
