package ReverseLinkedListTwo;

/**
 * Created by SimingYe on 2/11/16.
 */
public class ReverseLinkedListTwo2
{
    public ListNode reverseBetween(ListNode head, int m, int n)
    {
        if (head == null || head.next == null)
            return head;

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;

        ListNode node = fakeHead;
        int i = 0;

        while (node != null)
        {
            if (i == m - 1)
            {
                ListNode pre = node;
                ListNode cur = node.next;

                while (cur != null)
                {
                    if (i == n)
                    {
                        break;
                    }

                    ListNode next=  cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = next;
                    i++;
                }

                ListNode temp = node.next;
                node.next = pre;
                temp.next = cur;

                return fakeHead.next;
            }
            else
            {
                node = node.next;
                i++;
            }
        }

        return fakeHead.next;
    }

    public static void main(String[] args) {
        ReverseLinkedListTwo2 test = new ReverseLinkedListTwo2();
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
