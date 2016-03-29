package RemoveDuplicatesFromSortedListTwo;

import RemoveDuplicatesFromSortedList.RemoveDuplicatesFromSortedList2;

/**
 * Created by SimingYe on 2/10/16.
 */
public class RemoveDuplicatesFromSortedListTwo2
{
    public ListNode deleteDuplicates(ListNode head)
    {
        if (head == null || head.next == null)
            return head;

        ListNode p = head;

        while (p.next != null)
        {
            if (p.val == p.next.val)
            {
                ListNode n = p;
                while (n.next != null && n.val == n.next.val)
                {
                    n = n.next;
                }

                p.next = n.next;
            }
            else
            {
                p = p.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListTwo2 test = new RemoveDuplicatesFromSortedListTwo2();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(1);
        ListNode three = new ListNode(2);
        ListNode four = new ListNode(3);
        ListNode five = new ListNode(3);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        test.deleteDuplicates(one);
    }
}
