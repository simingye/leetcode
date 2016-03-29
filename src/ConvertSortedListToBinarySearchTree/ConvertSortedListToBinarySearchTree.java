package ConvertSortedListToBinarySearchTree;

/**
 * Created by Siming on 10/15/15.
 */
public class ConvertSortedListToBinarySearchTree
{
    public TreeNode sortedListToBST(ListNode head)
    {
        if (head == null)
            return null;

        int length = getLength(head);

        return construct(head, length);
    }

    public TreeNode construct(ListNode head, int n)
    {
        if (n <= 0)
            return null;

        int mid = (int)Math.ceil((n) / 2.0);

        ListNode listNode = findListNode(mid, head);
        TreeNode treeNode = new TreeNode(listNode.val);
        treeNode.left = construct(head, mid-1);
        treeNode.right = construct(listNode.next, n-mid);

        return treeNode;
    }

    public ListNode findListNode(int pos, ListNode head)
    {
        int i = 1;
        ListNode temp = head;
        while (temp != null)
        {
            if (i == pos)
            {
                break;
            }

            temp = temp.next;
            i++;
        }

        return temp;
    }

    public int getLength(ListNode node)
    {
        if (node == null)
            return 0;

        int count = 0;
        ListNode temp = node;
        while (temp != null)
        {
            temp = temp.next;
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        ConvertSortedListToBinarySearchTree test = new ConvertSortedListToBinarySearchTree();
        ListNode node = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);

        node.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;

        TreeNode temp = test.sortedListToBST(node);
        System.out.println(" fsfd");
    }
}
