package ConvertSortedArraytoBinarySearchTree;

/**
 * Created by Siming on 10/9/15.
 */
public class ConvertSortedArrayToBinaryTree
{
    public TreeNode sortedArrayToBST(int[] nums)
    {
        if (nums == null || nums.length == 0)
        {
            return null;
        }

        int start = 0;
        int end = nums.length - 1;

        return construct(nums, start, end);
    }

    public TreeNode construct(int[] nums, int start, int end)
    {
        if (start > end)
            return null;

        int mid = (int)Math.ceil((start + end) / 2.0);
        TreeNode node = new TreeNode(nums[mid]);

        node.left = construct(nums, start, mid-1);
        node.right = construct(nums, mid+1, end);

        return node;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBinaryTree test = new ConvertSortedArrayToBinaryTree();
        int[] nums = {1,2,3,4};
        test.sortedArrayToBST(nums);
    }
}
