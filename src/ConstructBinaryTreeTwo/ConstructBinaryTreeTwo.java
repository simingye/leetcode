package ConstructBinaryTreeTwo;

/**
 * Created by Siming on 10/5/15.
 */
public class ConstructBinaryTreeTwo
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

        TreeNode node = new TreeNode(postorder[postEnd]);

        int position = 0;
        for (int i = 0; i < inorder.length; i++)
        {
            if (inorder[i] == postorder[postEnd])
            {
                position = i;
                break;
            }
        }

        node.left = construct(inorder, postorder, inStart, position-1, postStart, postStart + position - (inStart+1));
        node.right = construct(inorder, postorder, position+1, inEnd, postStart+position-inStart, postEnd-1);

        return node;
    }
}
