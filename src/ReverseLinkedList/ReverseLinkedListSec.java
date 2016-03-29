package ReverseLinkedList;

/**
 * Created by Siming on 10/26/15.
 */
public class ReverseLinkedListSec
{
    public ListNode reverseList(ListNode head)
    {
        if (head == null || head.next == null)
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

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);

        one.next = two;
        two.next = three;

        ReverseLinkedListSec test = new ReverseLinkedListSec();
        System.out.println(test.reverseList(one));
    }
}
