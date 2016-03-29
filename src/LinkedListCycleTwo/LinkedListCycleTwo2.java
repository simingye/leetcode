package LinkedListCycleTwo;

/**
 * Created by SimingYe on 3/27/16.
 */
public class LinkedListCycleTwo2
{
    public ListNode detectCycle(ListNode head)
    {
        if (head == null)
            return head;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow)
            {
                slow = head;
                while (slow != fast)
                {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }

        return null;
    }
}
