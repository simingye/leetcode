package PartitionList;

import java.util.List;

/**
 * Created by Siming on 9/30/15.
 */
public class PartitionList
{
    public ListNode partition(ListNode head, int x)
    {
        if (head == null || head.next == null)
        {
            return head;
        }

        ListNode leftHead = new ListNode(0);
        ListNode rightHead = new ListNode(0);
        ListNode cur1 = leftHead;
        ListNode cur2 = rightHead;
        ListNode cur = head;

        while (cur != null)
        {
            if (cur.val < x)
            {
                cur1.next = cur;
                cur = cur.next;
                cur1 = cur1.next;
            }
            else
            {
                cur2.next = cur;
                cur = cur.next;
                cur2 = cur2.next;
            }
        }

        cur2.next = null;
        cur1.next = rightHead.next;

        return leftHead.next;
    }

    public static void main(String[] args) {
        PartitionList test = new PartitionList();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(4);
//        ListNode three = new ListNode(3);
//        ListNode four = new ListNode(2);
//        ListNode five = new ListNode(5);
//        ListNode six = new ListNode(2);
        one.next = two;
//        two.next = three;
//        three.next = four;
//        four.next = five;
//        five.next = six;
        test.partition(one, 4);
    }
}
