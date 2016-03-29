package SortList;

/**
 * Created by Siming on 10/28/15.
 */
public class SortList
{
    public ListNode sortList(ListNode head)
    {
        if (head == null || head.next == null)
            return head;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            if (fast == null)
            {
                break;
            }
            slow = slow.next;
        }

        ListNode left = head;
        ListNode right = slow.next;
        slow.next = null;

        ListNode h1 = sortList(left);
        ListNode h2 = sortList(right);

        ListNode res = merge(h1, h2);

        return res;
    }

    public ListNode merge(ListNode left, ListNode right)
    {
        ListNode p1 = left;
        ListNode p2 = right;

        ListNode fake = new ListNode(Integer.MIN_VALUE);
        ListNode p = fake;

        while (p1 != null || p2 != null)
        {
            if (p1 == null)
            {
                p.next = new ListNode(p2.val);
                p2 = p2.next;
                p = p.next;
            }
            else if (p2 == null)
            {
                p.next = new ListNode(p1.val);
                p1 = p1.next;
                p = p.next;
            }
            else
            {
                if (p1.val < p2.val)
                {
                    p.next = new ListNode(p1.val);
                    p1 = p1.next;
                    p = p.next;
                }
                else if (p1.val == p2.val)
                {
                    p.next = new ListNode(p1.val);
                    p.next.next = new ListNode(p2.val);
                    p1 = p1.next;
                    p2 = p2.next;
                    p = p.next.next;
                }
                else
                {
                    p.next = new ListNode(p2.val);
                    p2 = p2.next;
                    p = p.next;
                }
            }
        }

        return fake.next;
    }
}
