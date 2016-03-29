package BinarySearchTreeIterator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Siming on 10/30/15.
 */
public class BinarySearchTreeIterator
{
    TreeNode root;
    Queue<TreeNode> queue = new LinkedList<>();
    Stack<TreeNode> stack = new Stack<>();

    public BinarySearchTreeIterator(TreeNode root)
    {
        this.root = root;

        if (root != null)
        {
            TreeNode p = this.root;
            
            while (!stack.isEmpty() || p != null)
            {
                if (p != null)
                {
                    stack.push(p);
                    p = p.left;
                }
                else
                {
                    p = stack.pop();
                    queue.add(p);
                    p = p.right;
                }
            }
        }
    }

    public boolean hasNext()
    {
        return !queue.isEmpty();
    }

    public int next()
    {
        if (hasNext())
        {
            return queue.poll().val;
        }
        else
        {
            return -1;
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        BinarySearchTreeIterator test = new BinarySearchTreeIterator(node);
        System.out.println(test.hasNext());
        System.out.println(test.next());
        System.out.println(test.next());
    }
}
