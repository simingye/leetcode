package InsertionSortList;

/**
 * Created by SimingYe on 3/28/16.
 */
public class InsertionSortList2
{
    public ListNode insertionSortList(ListNode head)
    {
        if (head == null || head.next == null)
            return head;

        ListNode fakeHead = new ListNode(0);
        fakeHead.next = head;

        ListNode now = head.next;
        ListNode pre_now = head;
        boolean flag = false;

        while (now != null)
        {
            ListNode temp = fakeHead.next;
            ListNode pre_temp = fakeHead;
            while (temp != now)
            {
                if (now.val < temp.val)
                {
                    ListNode node = now.next;
                    now.next = temp;
                    pre_temp.next = now;
                    pre_now.next = node;
                    now = node;
                    flag = true;
                    break;
                }
                else
                {
                    temp = temp.next;
                    pre_temp = pre_temp.next;
                }
            }

            if (!flag)
            {
                pre_now = pre_now.next;
                now = now.next;
            }
            else
            {
                flag = false;
            }
        }

        return fakeHead.next;
    }

    public static void main(String[] args) {
        ListNode one = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(1);
        one.next = two;
        two.next = three;

        InsertionSortList2 test = new InsertionSortList2();
        test.insertionSortList(one);
    }
}
