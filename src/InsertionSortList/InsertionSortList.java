package InsertionSortList;

/**
 * Created by Siming on 10/27/15.
 */
public class InsertionSortList
{
    public ListNode insertionSortList(ListNode head)
    {
        if (head == null || head.next == null)
            return head;

        ListNode cur = head.next;
        ListNode n = new ListNode(head.val);
        ListNode pre = head;
        n.next = head;

        while (cur != null)
        {
            ListNode p = n;
            ListNode q = n.next;
            ListNode temp = cur.next;

            while (pre.next != cur)
                pre = pre.next;

            while (q != temp)
            {
                if (q == cur)
                {
                    break;
                }

                if (cur.val > p.val && cur.val <= q.val || (q == n.next && cur.val <= q.val))
                {
                    pre.next = cur.next;
                    cur.next = q;
                    p.next = cur;
                    break;
                }
                else
                {
                    q = q.next;
                    p = p.next;
                }
            }

            cur = temp;
        }

        return n.next;
    }

    public static void main(String[] args) {
        InsertionSortList test = new InsertionSortList();
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);

//        four.next = three;
//        three.next = five;
//        five.next = two;
//        two.next = one;
        two.next = one;

        System.out.println(test.insertionSortList(two));
    }
}
