package Interview;

/**
 * Created by Siming on 11/14/15.
 */
public class insertAndDelete
{
    public void insert(ListNode node, ListNode root)
    {
        ListNode head = root;

        while (head.next != null)
        {
            head = head.next;
        }

        head.next = node;
    }
}
