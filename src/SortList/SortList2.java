package SortList;

import PalindromeLinkedList.PalindromeLinkedList;

/**
 * Created by SimingYe on 3/28/16.
 */
public class SortList2
{
    public ListNode sortList(ListNode head)
    {
        if (head == null || head.next == null)
            return head;

        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = slow.next;
        slow.next = null;

        ListNode p1 = sortList(head);
        ListNode p2 = sortList(fast);

        return merge(p1, p2);
    }

    public ListNode merge(ListNode p1, ListNode p2)
    {
        if (p1 == null && p2 != null)
        {
            return p2;
        }
        else if (p2 == null && p1 != null)
        {
            return p1;
        }
        else if (p1 == null && p2 == null)
        {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode now = dummy;

        while (p1 != null && p2 != null)
        {
            if (p1.val <= p2.val)
            {
                now.next = p1;
                now = now.next;
                p1 = p1.next;
            }
            else
            {
                now.next = p2;
                now = now.next;
                p2 = p2.next;
            }
        }

        if (p1 != null)
        {
            now.next = p1;
        }
        else if (p2 != null)
        {
            now.next = p2;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        SortList2 test = new SortList2();
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(1);
        one.next = two;
        test.sortList(one);
    }
}
