package ReverseLinkedListTwo;

/**
 * Created by Siming on 10/1/15.
 */
public class ReverseLinkedListTwo
{
    public ListNode reverseBetween(ListNode head, int m, int n)
    {
        if (head == null || head.next == null)
            return head;

        int position = 1;

        ListNode node = new ListNode(0);
        node.next = head;

        ListNode left = node;
        ListNode right = node;

        ListNode pre = node;
        ListNode cur = head;
        ListNode next = head.next;

        while (cur != null)
        {
            if (position == m)
            {
                left = pre;
                right = cur;
            }

            if (position >= m && position <= n)
            {
                next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }

            if (position < m)
            {
                pre = pre.next;
                cur = cur.next;
                next = next.next;
            }

            if (position == n)
            {
                break;
            }

            position++;
        }

        left.next = pre;
        right.next = cur;

        return node.next;
    }

    public static void main(String[] args) {
        ReverseLinkedListTwo test = new ReverseLinkedListTwo();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        test.reverseBetween(one, 1, 5);
    }
}
