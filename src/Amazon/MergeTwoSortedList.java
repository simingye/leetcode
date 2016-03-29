package Amazon;

/**
 * Created by SimingYe on 2/17/16.
 */
public class MergeTwoSortedList
{
    public ListNode mergeTwoList(ListNode l1, ListNode l2)
    {
        ListNode p = l1;
        ListNode q = l2;
        ListNode fakeHead = new ListNode(0);
        ListNode node = fakeHead;

        while (p != null || q != null)
        {
            if (p.val <= q.val)
            {
                ListNode temp = p;
                node.next = temp;

                node = node.next;
                p = p.next;
            }
            else
            {
                ListNode temp = q;
                node.next = temp;

                node = node.next;
                q = q.next;
            }
        }

        if (p != null)
        {
            node.next = p;
        }
        else
        {
            node.next = q;
        }

        return fakeHead.next;
    }
}
