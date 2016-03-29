package ReverseLinkedList;

/**
 * Created by Siming on 6/19/15.
 */
public class ReverseLinkedList
{
    public ListNode reverstList (ListNode head)
    {
        if (head == null || head.next == null)
        {
            return  head;
        }

        ListNode previous = head;
        ListNode current = head.next;
        ListNode next = current.next;

        previous.next = null;

        while (current != null)
        {
            current.next = previous;
            previous = current;
            current = next;
            if (next != null)
            {
                next = next.next;
            }
        }

        return previous;
    }
}
