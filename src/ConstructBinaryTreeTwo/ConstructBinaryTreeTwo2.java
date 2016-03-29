package ConstructBinaryTreeTwo;

/**
 * Created by SimingYe on 2/13/16.
 */
public class ConstructBinaryTreeTwo2
{
    public TreeNode buildTree(int[] inorder, int[] postorder)
    {
        int inStart = 0;
        int inEnd = inorder.length - 1;
        int postStart = 0;
        int postEnd = postorder.length - 1;

        return construct(inorder, postorder, inStart, inEnd, postStart, postEnd);
    }

    public TreeNode construct(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd)
    {
        if (inStart > inEnd || postStart > postEnd)
            return null;

        int value = postorder[postEnd];
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

        p.left = construct(inorder, postorder, inStart, k-1, postStart, postStart+k-(inStart+1));
        p.right = construct(inorder, postorder, k+1, inEnd, postStart+k-inStart, postEnd-1);

        return p;
    }
}
