package LinkedListCycle;

/**
 * Created by Siming on 10/25/15.
 */
public class LinkedListCycle
{
    public boolean hasCycle(ListNode head)
    {
        if (head == null || head.next == null)
            return false;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null)
        {
            if (fast == slow)
                return true;

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
