package ConstructBinaryTree;

/**
 * Created by Siming on 10/4/15.
 */
public class ConstructBinaryTree
{
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
//        TreeNode root = new TreeNode(preorder[0]);

        int preStart = 0;
        int preEnd = preorder.length - 1;
        int inStart = 0;
        int inEnd = inorder.length - 1;

        return construct(preorder, inorder, preStart, preEnd, inStart, inEnd);
    }

    public TreeNode construct(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd)
    {
        if (preStart > preEnd || inStart > inEnd)
        {
            return null;
        }

        int val = preorder[preStart];
        TreeNode node = new TreeNode(val);

        int position = 0;
        for (int i = 0; i < inorder.length; i++)
        {
            if (inorder[i] == val)
            {
                position = i;
                break;
            }
        }

        node.left = construct(preorder, inorder, preStart+1, preStart+(position-inStart), inStart, position-1);
        node.right = construct(preorder, inorder, preStart+(position-inStart)+1, preEnd, position+1, inEnd);

        return node;
    }

    public static void main(String[] args) {
        ConstructBinaryTree test = new ConstructBinaryTree();
//        TreeNode one = new TreeNode(1);
//        TreeNode two = new TreeNode(2);
//        TreeNode three = new TreeNode(3);
//
//        one.left = two;
//        two.right = three;
        int[] preorder = {1,2,3};
        int[] inorder = {2,3,1};
        System.out.println(test.buildTree(preorder, inorder));
    }
}
