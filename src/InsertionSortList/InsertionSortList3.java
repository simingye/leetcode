package InsertionSortList;

/**
 * Created by SimingYe on 3/28/16.
 */
public class InsertionSortList3
{
    public ListNode insertionSortList(ListNode head)
    {
        if (head == null)
            return head;

        ListNode dummy = new ListNode(0);

        while (head != null)
        {
            ListNode node = dummy;
            while (node.next != null && node.next.val < head.val)
            {
                node = node.next;
            }

            ListNode temp = head.next;
            head.next = node.next;
            node.next = head;
            head = temp;
        }

        return dummy.next;
    }
}
