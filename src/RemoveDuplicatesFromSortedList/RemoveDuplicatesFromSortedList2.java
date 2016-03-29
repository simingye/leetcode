package RemoveDuplicatesFromSortedList;

/**
 * Created by SimingYe on 2/10/16.
 */
public class RemoveDuplicatesFromSortedList2
{
    public ListNode deleteDuplicates(ListNode head)
    {
        if (head == null || head.next == null)
            return head;

        ListNode node = new ListNode(0);
        node.next = head;

        ListNode p = node;
        while (p.next != null && p.next.next != null)
        {
            if (p.next.val == p.next.next.val)
            {
                int dup = p.next.val;
                while (p.next != null && p.next.val == dup)
                {
                    p.next = p.next.next;
                }
            }
            else
            {
                p = p.next;
            }
        }

        return node.next;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList2 test = new RemoveDuplicatesFromSortedList2();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(3);
        ListNode five = new ListNode(4);
        ListNode six = new ListNode(4);
        ListNode seven = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;

        test.deleteDuplicates(one);
    }
}
