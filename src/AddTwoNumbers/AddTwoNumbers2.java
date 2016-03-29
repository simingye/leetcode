package AddTwoNumbers;

/**
 * Created by SimingYe on 1/25/16.
 */
public class AddTwoNumbers2
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        if (l1 == null && l2 == null)
            return null;

        ListNode head = new ListNode(0);
        ListNode node = head;
        int flag = 0;

        while (l1 != null && l2 != null)
        {
            ListNode temp = new ListNode((l1.val + l2.val + flag) % 10);
            flag = (l1.val + l2.val + flag) / 10;
            node.next = temp;
            node = node.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null)
        {
            ListNode temp = new ListNode((l1.val + flag) % 10);
            flag = (l1.val + flag) / 10;
            node.next = temp;
            node = node.next;
            l1 = l1.next;
        }

        while (l2 != null)
        {
            ListNode temp = new ListNode((l2.val + flag) % 10);
            flag = (l2.val + flag) / 10;
            node.next = temp;
            node = node.next;
            l2 = l2.next;
        }

        if (flag != 0)
        {
            ListNode temp = new ListNode(flag);
            node.next = temp;
        }

        return head.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers2 test = new AddTwoNumbers2();
        ListNode one = new ListNode(3);
        ListNode two = new ListNode(7);
        ListNode three = new ListNode(9);
        ListNode four = new ListNode(2);
        one.next = two;
        three.next = four;

        test.addTwoNumbers(one, three);
    }
}
