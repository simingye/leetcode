package PartitionList;

/**
 * Created by SimingYe on 2/10/16.
 */
public class PartitionList2
{
    public ListNode partition(ListNode head, int x)
    {
        if (head == null || head.next == null)
            return head;

        ListNode fakeHead1 = new ListNode(0);
        ListNode fakeHead2 = new ListNode(0);
        fakeHead1.next = head;

        ListNode p = head;
        ListNode pre = fakeHead1;
        ListNode p2 = fakeHead2;

        while (p != null)
        {
            if (p.val < x)
            {
                p = p.next;
                pre = pre.next;
            }
            else
            {
                p2.next = p;
                pre.next = p.next;

                p = pre.next;
                p2 = p2.next;
            }
        }

        p2.next = null;

        pre.next = fakeHead2.next;

        return fakeHead1.next;
    }
}
