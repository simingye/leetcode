package ReorderList;

/**
 * Created by SimingYe on 3/27/16.
 */
public class ReorderList2
{
    public void reorderList(ListNode head)
    {
        if (head == null || head.next == null || head.next.next == null)
            return;

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode second = slow.next;
        slow.next = null;

        second = reverse(second);

        ListNode p1 = head;
        ListNode p2 = second;

        while (p2 != null)
        {
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;

            p1.next = p2;
            p2.next = temp1;

            p1 = temp1;
            p2 = temp2;
        }
    }

    public ListNode reverse(ListNode head)
    {
        if (head == null || head.next == null)
            return head;

        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null)
        {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        head.next = null;

        return pre;
    }

    public static void main(String[] args) {
        ReorderList2 test = new ReorderList2();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        one.next = two;
        two.next = three;

        test.reorderList(one);
    }
}
