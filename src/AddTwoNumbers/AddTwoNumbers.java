package AddTwoNumbers;

import java.util.List;

/**
 * Created by Siming on 7/1/15.
 */
public class AddTwoNumbers
{
    public ListNode addTwoNumbers (ListNode l1, ListNode l2)
    {
        if (l1 == null)
            return l2;

        if (l2 == null)
            return l1;

        int a = 0;
        int b = 0;
//        ListNode root = new ListNode((l1.val + l2.val) % 10);
        ListNode root = new ListNode(0);
        ListNode result = root;

        while (l1 != null || l2 != null)
        {
            if (l1 != null && l2 == null)
            {
                b = (a + l1.val) % 10;
                a = (a + l1.val) / 10;
            }
            else if (l1 == null && l2 != null)
            {
                b = (a + l2.val) % 10;
                a = (a + l2.val) / 10;
            }
            else
            {
                b = (l1.val + l2.val + a) % 10;
                a = (l1.val + l2.val + a) / 10;
            }

            ListNode node = new ListNode(b);

            root.next = node;
            root = root.next;

            if (l1 != null)
            {
                l1 = l1.next;
            }

            if (l2 != null)
            {
                l2 = l2.next;
            }
        }

        if (a != 0)
        {
            root.next = new ListNode(a);
        }

        return result.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers test = new AddTwoNumbers();
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(2);
        ListNode l11 = new ListNode(3);
        ListNode l21 = new ListNode(4);
//        l1.next = l11;
//        l2.next = l21;
        System.out.println(test.addTwoNumbers(l1, l2));
    }
}
