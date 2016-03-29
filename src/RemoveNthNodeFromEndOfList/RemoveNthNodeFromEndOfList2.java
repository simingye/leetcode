package RemoveNthNodeFromEndOfList;

/**
 * Created by SimingYe on 1/27/16.
 */
public class RemoveNthNodeFromEndOfList2
{
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        if (head == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;
        int i = 0;

        while (i != n)
        {
            fast = fast.next;
            i++;
            if (fast == null)
            {
                return head.next;
            }
        }

        while (fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}
