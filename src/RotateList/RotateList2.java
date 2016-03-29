package RotateList;

/**
 * Created by SimingYe on 2/4/16.
 */
public class RotateList2
{
    public ListNode rotateRight(ListNode head, int k)
    {
        if (head == null || head.next == null || k == 0)
            return head;

        ListNode fast = head;
        ListNode slow = head;
        int count = 0;

        ListNode node = head;
        int length = 0;
        while (node != null)
        {
            node = node.next;
            length++;
        }

        if (length <= k)
        {
            k = k % length;
        }

        if (k == 0)
            return head;


        while (fast.next != null)
        {
            if (count == k)
            {
                fast = fast.next;
                slow = slow.next;
            }
            else
            {
                fast = fast.next;
                count++;
            }
        }

        if (count != k)
        {
            return head;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
//        ListNode three = new ListNode(3);
//        ListNode four = new ListNode(4);
//        ListNode five = new ListNode(5);
//
        one.next = two;
//        two.next = three;
//        three.next = four;
//        four.next = five;

        RotateList2 test = new RotateList2();
        test.rotateRight(one, 3);
    }
}
