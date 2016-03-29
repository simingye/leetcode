package RemoveDuplicatesFromSortedListTwo;

/**
 * Created by Siming on 9/29/15.
 */
public class RemoveDuplicatesFromSortedListTwo
{
    public ListNode deleteDuplicates(ListNode head)
    {
        if (head == null)
            return head;

        ListNode t = new ListNode(0);
        t.next = head;

        ListNode cur = t;

        while (cur.next != null)
        {
            ListNode node = cur.next;
            while (node.next != null && node.val == node.next.val)
            {
                node = node.next;
            }

            if (node != cur.next)
            {
                cur.next = node.next;
            }
            else
            {
                cur = cur.next;
            }
        }

        return t.next;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListTwo test = new RemoveDuplicatesFromSortedListTwo();
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
