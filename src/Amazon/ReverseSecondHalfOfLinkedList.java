package Amazon;

/**
 * Created by SimingYe on 2/17/16.
 */
public class ReverseSecondHalfOfLinkedList
{
    public ListNode reverse(ListNode head)
    {
        if (head == null || head.next == null)
            return head;

        ListNode fast = head.next;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode pre = slow.next;
        ListNode cur = pre.next;
        pre.next = null;

        while (cur != null)
        {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        slow.next = pre;

        return head;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;

        ReverseSecondHalfOfLinkedList test = new ReverseSecondHalfOfLinkedList();
        test.reverse(one);
    }
}
