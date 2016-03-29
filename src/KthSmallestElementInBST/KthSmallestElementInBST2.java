package KthSmallestElementInBST;

import java.util.Stack;

/**
 * Created by SimingYe on 3/10/16.
 */
public class KthSmallestElementInBST2
{
    public int kthSmallest(TreeNode root, int k)
    {
        if (root == null)
            return -1;

        int count = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode now = root;

        while (now != null || !stack.isEmpty())
        {
            if (now != null)
            {
                stack.push(now);
                now = now.left;
            }
            else
            {
                TreeNode temp = stack.pop();
                count++;
                now = temp.right;
                if (count == k)
                {
                    return temp.val;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        KthSmallestElementInBST2 test = new KthSmallestElementInBST2();
        TreeNode one = new TreeNode(1);
        System.out.println(test.kthSmallest(one, 1));
    }
}
