package LinkedListCycleTwo;

/**
 * Created by Siming on 10/25/15.
 */
public class LinkedListCycleTwo
{
    public ListNode detectCycle(ListNode head)
    {
        if (head == null || head.next == null)
            return null;

        ListNode fast = head;
        ListNode slow = head;

        while (true)
        {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == null || fast.next == null)
                return null;

            if (fast == slow)
            {
                slow = head;
                break;
            }
        }

        while (slow != fast)
        {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }
}
