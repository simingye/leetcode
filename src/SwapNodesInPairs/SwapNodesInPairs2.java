package SwapNodesInPairs;

/**
 * Created by SimingYe on 1/27/16.
 */
public class SwapNodesInPairs2
{
    public ListNode swapPairs(ListNode head)
    {
        if (head == null || head.next == null)
            return head;

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;

        ListNode p = fakeHead;
        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p.next != null && p.next.next != null)
        {
            p.next = p2;
            p1.next = p2.next;
            p2.next = p1;

            p = p1;
            p1 = p.next;

            if (p1 != null)
            {
                p2 = p1.next;
            }
        }

        return fakeHead.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);

        one.next = two;
        two.next = three;
//        three.next = four;

        SwapNodesInPairs2 test =  new SwapNodesInPairs2();
        test.swapPairs(one);
    }
}
