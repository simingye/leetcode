package RotateList;

import java.util.List;

/**
 * Created by Siming on 9/12/15.
 */
public class RotateList
{
    public ListNode rotateRight(ListNode head, int k)
    {
        if (head == null || k == 0)
            return head;


        ListNode temp = head;

        int length = 1;
        while (temp.next != null)
        {
            length++;
            temp = temp.next;
        }

        temp.next = head;

        int n = length - k % length;
        ListNode preHead = temp;

        while (n > 0)
        {
            preHead = preHead.next;
            n--;
        }

        head = preHead.next;
        preHead.next = null;

        return head;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        RotateList test = new RotateList();
        System.out.println(test.rotateRight(one, 3).val);
    }
}
