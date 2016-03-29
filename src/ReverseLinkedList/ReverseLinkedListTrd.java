package ReverseLinkedList;

/**
 * Created by Siming on 11/9/15.
 */
public class ReverseLinkedListTrd
{
    public ListNode reverseList(ListNode head)
    {
        if (head == null)
            return head;

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null)
        {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
