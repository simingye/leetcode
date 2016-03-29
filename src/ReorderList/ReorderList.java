package ReorderList;

import org.w3c.dom.NodeList;

/**
 * Created by Siming on 10/26/15.
 */
public class ReorderList
{
    public void reorderList(ListNode head)
    {
        if (head == null || head.next == null)
            return;

        ListNode fast = head;
        ListNode slow = head;

        //find the middle node
        while (fast.next != null && fast.next.next != null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }

        //now p is middle node
        //reverse p.next to end
        //1,2,3,4,5,6,7
        ListNode second = slow.next;
        slow.next = null;

        second = reverseOrder(second);

        ListNode p1 = head;
        ListNode p2 = second;

        //merge two lists
        //1,2,3,4
        //7,6,5
        while (p2 != null)
        {
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;

            p1.next = p2;
            p2.next = temp1;

            p1 = temp1;
            p2 = temp2;
        }

        System.out.println(head.val);
    }

    public ListNode reverseOrder(ListNode head)
    {
        if (head == null || head.next == null)
            return head;

        ListNode pre = head;
        ListNode cur = head.next;

        while (cur != null)
        {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        head.next = null;

        return pre;
    }

    public static void main(String[] args) {
        ReorderList test = new ReorderList();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(7);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;

        test.reorderList(one);
    }
}
