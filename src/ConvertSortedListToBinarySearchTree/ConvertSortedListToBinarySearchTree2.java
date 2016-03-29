package ConvertSortedListToBinarySearchTree;

/**
 * Created by SimingYe on 2/22/16.
 */
public class ConvertSortedListToBinarySearchTree2
{
    private ListNode current;

    public TreeNode sortedListToBST(ListNode head)
    {
        if (head == null)
            return null;

        int len = 0;
        current = head;
        len = getLength(head);

        return build(len);
    }

    public int getLength(ListNode head)
    {
        int length = 0;

        while (head != null)
        {
            head = head.next;
            length++;
        }

        return length;
    }

    public TreeNode build(int length)
    {
        if (length <= 0)
            return null;

        TreeNode left = build(length/2);
        TreeNode node = new TreeNode(current.val);
        current = current.next;
        TreeNode right = build(length/2 - 1);

        node.left = left;
        node.right = right;

        return node;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        one.next = two;
        two.next = three;

        ConvertSortedListToBinarySearchTree2 test = new ConvertSortedListToBinarySearchTree2();
        test.sortedListToBST(one);
    }
}
