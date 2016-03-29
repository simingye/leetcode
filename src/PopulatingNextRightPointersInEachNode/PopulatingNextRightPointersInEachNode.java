package PopulatingNextRightPointersInEachNode;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Siming on 10/19/15.
 */
public class PopulatingNextRightPointersInEachNode
{
    public void connect(TreeLinkNode root)
    {
        if (root == null)
            return;

        TreeLinkNode p = root;
        TreeLinkNode first = null;

        while (p.left != null)
        {
            if (first == null)
            {
                first = p.left;
            }

            p.left.next = p.right;

            if (p.next != null)
            {
                p.right.next = p.next.left;
                p = p.next;
            }
            else
            {
                p = first;
                first = null;
            }
        }

        System.out.println("ss");
    }

    public static void main(String[] args) {
        PopulatingNextRightPointersInEachNode test = new PopulatingNextRightPointersInEachNode();
        TreeLinkNode one = new TreeLinkNode(1);
        TreeLinkNode two = new TreeLinkNode(2);
        TreeLinkNode three = new TreeLinkNode(3);
        TreeLinkNode four = new TreeLinkNode(4);
        TreeLinkNode five = new TreeLinkNode(5);
        TreeLinkNode six = new TreeLinkNode(6);
        TreeLinkNode seven = new TreeLinkNode(7);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;

        test.connect(one);
    }
}
