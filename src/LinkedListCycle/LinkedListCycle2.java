package LinkedListCycle;

/**
 * Created by SimingYe on 3/27/16.
 */
public class LinkedListCycle2
{
    public boolean hasCycle(ListNode head)
    {
        if (head == null)
            return false;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
                return true;
        }

        return false;
    }
}
