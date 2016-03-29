package ConvertSortedArraytoBinarySearchTree;

/**
 * Created by SimingYe on 2/22/16.
 */
public class ConvertSortedArrayToBinaryTree2
{
    public TreeNode sortedArrayToBST(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return null;

        return build(nums, 0, nums.length-1);
    }

    public TreeNode build(int[] nums, int start, int end)
    {
        if (start > end)
            return null;

        int pos = (start + end) / 2;
        TreeNode node = new TreeNode(nums[pos]);

        node.left = build(nums, start, pos-1);
        node.right = build(nums, pos+1, end);

        return node;
    }
}
